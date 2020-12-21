package pres.lnk.sofa.demo.biz;

import com.alipay.sofa.ark.spi.service.ArkInject;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import pres.lnk.sofa.demo.facade.FacadeService;
import pres.lnk.sofa.demo.plugin.PluginService;

import javax.annotation.PostConstruct;

/**
 * @Author linnankun
 * @Date 2020/12/16
 */
@RestController
public class BizTest {
    private final static Logger logger = LoggerFactory.getLogger(BizTest.class);

    /**
     * 注入插件发布的服务
     * {@link pres.lnk.sofa.demo.plugin.Starter}
     */
    @ArkInject(uniqueId = "pluginService")
    private FacadeService pluginService;

    /**
     * 注入其它biz服务发布的服务
     * {@link pres.lnk.sofa.demo.biz.service.TestService}
     */
    @SofaReference(uniqueId = "testService")
    private FacadeService testService;

    @PostConstruct
    public void init() {
        logger.info("biz test init");
        new Thread(() -> {
            // 直接new一个插件服务
            FacadeService newService = new PluginService();
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    logger.info("pluginService");
                    logger.info(pluginService.sayHello());
                } catch (Exception e) {
                    logger.info(e.getMessage(), e);
                }
                try {
                    logger.info("testService");
                    logger.info(testService.sayHello());
                } catch (Exception e) {
                    logger.info(e.getMessage(), e);
                }
                try {
                    logger.info("newService");
                    logger.info(newService.sayHello());
                } catch (Exception e) {
                    logger.info(e.getMessage());
                }
            }
        }).start();
    }
}
