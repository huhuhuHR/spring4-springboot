package com.example.demo.utils;


import com.example.demo.constant.Constant;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.UUID;

public class ImageUploadUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageUploadUtils.class);

    @SneakyThrows
    public static String uploadImage(MultipartFile file) {
        String name = file.getOriginalFilename();
        InputStream is = file.getInputStream();
        return uploadImage(name, is);
    }

    @SneakyThrows
    public static String uploadImage(String name, InputStream is) {
        String suffix = getSuffix(name);
        if (StringUtils.isEmpty(suffix)) {
            return "";
        }
        BufferedImage bi = ImageIO.read(is);
        Graphics g = bi.getGraphics();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String imageName = String.valueOf(uuid).concat(".").concat(suffix);
        try {
            g.drawImage(bi, 0, 0, null);
            ImageIO.write(bi, suffix, new File(Constant.IMG_PREFIX.concat(imageName)));
        } catch (IOException e) {
            LOGGER.error("ImageUploadUtils.uploadImage catch a exception,{}", e);
            return "";
        }
        is.close();
        return imageName;
    }

    private static String getSuffix(String name) {
        String suffix = "";
        if (name.contains("jpg")) {
            suffix = "jpg";
        } else if (name.contains("png")) {
            suffix = "png";
        } else if (name.contains("jpeg")) {
            suffix = "jpeg";
        }
        return suffix;
    }

    public static String uploadImage(String base64) {
        String suffix = chargeSuffix(base64);
        String base64Sub = subBase64(base64);
        return GenerateImage(base64Sub, Constant.IMG_PREFIX, suffix);
    }

    private static String subBase64(String base64) {
        int index = base64.indexOf(",") + 1;
        return base64.substring(index);
    }

    private static String chargeSuffix(String base64) {
        int index = base64.indexOf(",") + 1;
        String strPix = base64.substring(0, index);
        String result = "";
        if (strPix.contains("jpg")) {
            result = ".jpg";
        } else if (strPix.contains("png")) {
            result = ".png";
        } else if (strPix.contains("jpeg")) {
            result = ".jpeg";
        }
        return result;
    }

    private static String GenerateImage(String base64Image, String prefix, String suffix) {
        if (StringUtils.isEmpty(base64Image)) {
            return "";
        }
        String imageName = "";
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out = null;
        try {
            byte[] b = decoder.decodeBuffer(base64Image);
            for (int i = 0; i < b.length; i++) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            imageName = String.valueOf(uuid);
            String imgFilePath = prefix.concat(imageName).concat(suffix);
            out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return imageName.concat(suffix);
    }
}
