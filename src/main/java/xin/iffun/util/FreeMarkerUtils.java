package xin.iffun.util;/**
 * Created by Easong on 2017/12/16.
 */

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

/**
 * Description: FreeMarker模板工具
 *
 * @param
 * @author Easong
 * @version 2017/12/16
 * @since JDK1.7
 */
public class FreeMarkerUtils {

    private HttpServletRequest request;

    public FreeMarkerUtils() {

    }

    public FreeMarkerUtils(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(FreeMarkerUtils.class);

    /**
     * Description: 根据模板生成
     *
     * @param ftlName:模板名称 dataMap： 模板数据
     *                     filePath: 文件路径
     *                     fireName: 文件名称
     * @author Easong
     * @version 2017/12/16
     * @since JDK1.7
     */
    public String productionDoc(Map<String, Object> dataMap, String ftlName, String filePath, String fileName, String tmpDirName) {
        Writer out = null;
        try {
            //创建配置实例
            Configuration configuration = new Configuration();
            // 获取根目录
            // File templatePath = new File(ResourceUtils.getURL("classpath:").getPath(), "template");
            // 修改编码格式
            configuration.setDefaultEncoding("UTF-8");
            // 获取模板目录
            configuration.setClassForTemplateLoading(FreeMarkerUtils.class,"/template");
            // 获取模板
            Template template = configuration.getTemplate(ftlName);

            //输出文件
            File outFile = new File(filePath + File.separator + fileName);
            //如果输出目标文件夹不存在，则创建
            if (!outFile.getParentFile().exists()) {
                outFile.getParentFile().mkdirs();
            }
            //将模板和数据模型合并生成文件
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
            //生成文件
            template.process(dataMap, out);
            out.flush();
        } catch (Exception ex) {
            logger.error("生成模板错误" + ftlName);
            ex.printStackTrace();
        } finally {
            //关闭流
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return fileName;
    }
}
