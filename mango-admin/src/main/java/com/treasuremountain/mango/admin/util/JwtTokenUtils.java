package com.treasuremountain.mango.admin.util;

import com.treasuremountain.mango.admin.security.GrantedAuthorityImpl;
import com.treasuremountain.mango.admin.security.JwtAuthenticationToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.*;

/**
 * jwt工具
 *
 * @author mengyuanming
 * @version 1.0
 * @date 2020/12/14 15:26
 */
public class JwtTokenUtils implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名称
     */
    private static final String USERNAME = Claims.SUBJECT;

    /**
     * 创建时间
     */
    private static final String CREATED = "created";

    /**
     * 权限列表
     */
    private static final String AUTHORITIES = "authorities";

    /**
     * 密钥
     */
    private static final String SECRET = "abcdefgh";

    /**
     * 有效期12小时
     */
    private static final long EXPIRE_TIME = 12 * 60 * 60 * 1000;


    /**
     * 根据请求令牌获取登录认证信息
     *
     * @param request
     * @return
     */
    public static Authentication getAuthenticationFromToken(HttpServletRequest request) {
        Authentication authentication = null;
        // 获取请求携带的令牌
        String token = JwtTokenUtils.getToken(request);
        if (token != null) {
            // 请求令牌不能为空
            if (SecurityUtils.getAuthentication() == null) {
                // 上下文中Authentication为空
                Claims claims = getClaimsFromToken(token);
                if (claims == null) {
                    return null;
                }
                String username = claims.getSubject();
                if (username == null) {
                    return null;
                }
                if (isTokenExpired(token)) {
                    return null;
                }
                Object authors = claims.get(AUTHORITIES);
                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                if (authors instanceof List) {
                    for (Object object : (List) authors) {
                        authorities.add(new GrantedAuthorityImpl((String) ((Map) object).get("authority")));
                    }
                }
                authentication = new JwtAuthenticationToken(username, null, authorities, token);
            } else {
                if (validateToken(token, SecurityUtils.getUsername())) {
                    // 如果上下文中Authentication非空，且请求令牌合法，直接返回当前登录认证信息
                    authentication = SecurityUtils.getAuthentication();
                }
            }
        }
        return authentication;
    }

    /**
     * 获取请求token，默认从“Authorization”参数以“bearer”开头的信息为令牌信息
     * 若为空，则从“token”获取
     *
     * @param request
     * @return
     */
    public static String getToken(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        String tokenHead = "Bearer";

        if (token == null) {
            token = request.getHeader("token");
        } else if (token.contains(tokenHead)) {
            token = token.substring(tokenHead.length());
        }

        if ("".equals(token)) {
            token = null;
        }

        return token;
    }

    /**
     * 生成令牌
     *
     * @param authentication 用户
     * @return 令牌
     */
    public static String generateToken(Authentication authentication) {

        Map<String, Object> claims = new HashMap<>(3);
        claims.put(USERNAME, SecurityUtils.getUsername(authentication));
        claims.put(CREATED, new Date());
        claims.put(AUTHORITIES, authentication.getAuthorities());
        return generateToken(claims);
    }

    /**
     * 从数据声明生成令牌
     *
     * @param claims
     * @return
     */
    private static String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        return Jwts.builder().setClaims(claims).setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();
    }

    /**
     * 从令牌获取用户名
     *
     * @param token
     * @return
     */
    public static String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token
     * @return
     */
    private static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 验证令牌
     *
     * @param token
     * @param username
     * @return
     */
    public static Boolean validateToken(String token, String username) {
        String userName = getUsernameFromToken(token);
        return (userName.equals(username) && !isTokenExpired(token));
    }

    /**
     * 刷新令牌
     *
     * @param token
     * @return
     */
    public static String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put(CREATED, new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
     * 判断令牌是否过期
     *
     * @param token
     * @return
     */
    public static Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

}
