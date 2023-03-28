package code.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.util.*;

/**
 * ，第一部分头部，第二部分载荷，第三部分签名，最终形式：Header.Payload.Signature
 *
 *
 *  Base64Url这个算法跟Base64算法基本类似，但有一些小的不同。
 *  JWT作为一个令牌(token)，有些场合可能会放到URL(比如 api.example.com/?token=xxx)。
 *  Base64有三个字符+、/和=，在 URL 里面有特殊含义，所以要被替换掉：=被省略、+替换成-，/替换成_ ，这就是Base64Url算法。
 */
public class JWTTest {
    JwtBuilder jwtBuilder;

    String token;

    @Before
    public void init(){
        jwtBuilder = Jwts.builder();
    }

    /**
     * ===================================接下来准备生成token
     */
    @Test
    public void test01(){
        //设置官方规定的字段，根据需求设置
        jwtBuilder.setIssuer("小冷");//令牌颁发者
        jwtBuilder.setIssuedAt(new Date());//令牌颁发时间
        jwtBuilder.setAudience("不知名的客户端");//令牌接收者
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + 3600000));//令牌过期时间，1小时以后
        jwtBuilder.setId(UUID.randomUUID().toString());//设置令牌编号

        //设置签名算法和密钥（盐）
        jwtBuilder.signWith(SignatureAlgorithm.HS256, "123456789abcdefg");

        //设置自定义的字段，根据需求设置
        Map<String, Object> claims = new HashMap<>();
        claims.put("age", 24);
        claims.put("money", 1234);
        jwtBuilder.addClaims(claims);


        //生成一个token令牌
        token = jwtBuilder.compact();
        System.out.println(token); //eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiLlsI_lhrciLCJpYXQiOjE2NjA1Mjg4MzMsImF1ZCI6IuS4jeefpeWQjeeahOWuouaIt-erryIsImV4cCI6MTY2MDUzMjQzMywianRpIjoiMjBiMjdmMmItNmU4ZS00NjcxLThkMTUtOTFlODU5ZTBkNjI2IiwibW9uZXkiOjEyMzQsImFnZSI6MjR9.s9-yOuFKeTNrG2TTGKxDunrKj-yed7SuGcs0H-9uS6U
    }

    /**
     *     解析
     *
     *     在线解码网址：https://tooltt.com/jwt-decode/    其中头部和载荷的Base64Url编码，几乎是透明的，毫无安全性可言
     */
    @Test
    public void test02(){
        /**
         * =============================；======接下来准备解析token
         */
        token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiLlsI_lhrciLCJpYXQiOjE2NjA1Mjg4MzMsImF1ZCI6IuS4jeefpeWQjeeahOWuouaIt-erryIsImV4cCI6MTY2MDUzMjQzMywianRpIjoiMjBiMjdmMmItNmU4ZS00NjcxLThkMTUtOTFlODU5ZTBkNjI2IiwibW9uZXkiOjEyMzQsImFnZSI6MjR9.s9-yOuFKeTNrG2TTGKxDunrKj-yed7SuGcs0H-9uS6U";
        Claims body = Jwts.parser().setSigningKey("123456789abcdefg").parseClaimsJws(token).getBody();
        System.out.println(body);
    }


    /**
     *      模拟场景
     */
    @Test
    public void test03(){
        //用户登录，获取数据库用户表的信息
        //假如用户id：1
        JwtBuilder builder = Jwts.builder()
                //设置用户id
                .setId("13714858284")
                //设置主题（这个主题是干什么用的？，也可以不设置，感觉可以放其他重要的信息）
                .setSubject("congerfei")
                //设置创建时间
                .setIssuedAt(new Date())
                //设置过期时间
                .setExpiration(new Date(new Date().getTime() + 60000))
                //设置角色名称
                .claim("roles","admin")
                //自定义key(可以理解为解密的钥匙一般在配置文件里面)
                .signWith(SignatureAlgorithm.HS256, "bwcyguil");
        //用户登录之后，返回给前端token
        System.out.println("token..."+builder.compact());

        //前端请求带着token，后端解析
        Claims claims=Jwts.parser().setSigningKey("bwcyguil").parseClaimsJws(builder.compact()).getBody();
        //获取用户id
        System.out.println("id:"+claims.getId());
        //获取主题
        System.out.println("subject:"+claims.getSubject());
        //获取token创建时间（格式化时间引的jar为org.joda.time.DateTime）
        System.out.println("IssuedAt:"+ new DateTime(claims.getIssuedAt()).toString("yyyy-MM-dd HH:mm:ss"));
        //获取角色名称
        System.out.println("roles:"+claims.get("roles"));
    }


    /**
     * 解码头部
     *   eyJhbGciOiJIUzI1NiJ9
     * 解码后：{"alg":"HS256"}
     */
    @Test
    public void test04(){
        String s = "eyJhbGciOiJIUzI1NiJ9";
        byte[] bytes = s.getBytes();
        bytes = Base64.getDecoder().decode(bytes);
        System.out.println("解码后：" + new String(bytes));

    }

    /**
     * 解析 载荷
     *     eyJpc3MiOiLlsI_lhrciLCJpYXQiOjE2NjA1Mjg4MzMsImF1ZCI6IuS4jeefpeWQjeeahOWuouaIt-erryIsImV4cCI6MTY2MDUzMjQzMywianRpIjoiMjBiMjdmMmItNmU4ZS00NjcxLThkMTUtOTFlODU5ZTBkNjI2IiwibW9uZXkiOjEyMzQsImFnZSI6MjR9
            暂时还不知道如何直接解析载荷部分
     */
    @Test
    public void test05(){
        String s = "s9-yOuFKeTNrG2TTGKxDunrKj-yed7SuGcs0H-9uS6U";
        byte[] bytes = s.getBytes();
        bytes = Base64.getDecoder().decode(bytes);
        System.out.println("解码后：" + new String(bytes));
    }


    /**
     *  RAS  非对称加密算法
     */
    @Test
    public void test06() throws Exception{
        // 定义密钥
        String secret = "123456";

        // 固定格式
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom(secret.getBytes());
        keyPairGenerator.initialize(2048, secureRandom);

        // 生成一对公钥和私钥，KeyPair内部就是由PublicKey和PrivateKey组成
        KeyPair keyPair = keyPairGenerator.genKeyPair();

        // 获取公钥并对公钥进行Base64编码（编码后方便查看，你不编码啥都看不懂）
        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        //System.out.println(new String(publicKeyBytes));
        publicKeyBytes = Base64.getEncoder().encode(publicKeyBytes);
        System.out.println("公钥Base64编码后：" + new String(publicKeyBytes));

        // 获取私钥并对私钥进行Base64编码（编码后方便查看，你不编码啥都看不懂）
        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
        //System.out.println(new String(privateKeyBytes));
        privateKeyBytes = Base64.getEncoder().encode(privateKeyBytes);
        System.out.println("私钥Base64编码后：" + new String(privateKeyBytes));
    }


}
