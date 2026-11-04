package cc.yangmingtao



//生成公钥私钥

import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.SecureRandom

try {
    // 1. 初始化 RSA 密钥对生成器（长度通常为 2048 位）
    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
    keyGen.initialize(2048, new SecureRandom());

    // 2. 生成公私钥对
    KeyPair keyPair = keyGen.generateKeyPair();

    // 3. 获取公钥和私钥的字节数组
    byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
    byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();

    // 4. 使用 Base64 编码转换为字符串（方便在 JMeter 日志查看和文本传输）
    String publicKeyStr = Base64.getEncoder().encodeToString(publicKeyBytes);
    String privateKeyStr = Base64.getEncoder().encodeToString(privateKeyBytes);

    // 5. 存入 JMeter 变量中
    vars.put("PUBLIC_KEY", publicKeyStr);
    vars.put("PRIVATE_KEY", privateKeyStr);

    log.info("RSA 公私钥生成成功并已保存到 vars 中！");

} catch (Exception e) {
    log.error("生成 RSA 密钥对失败: " + e.getMessage(), e);
    throw e;
}