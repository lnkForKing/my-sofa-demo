package pres.lnk.sofa.demo.plugin;

import com.alipay.sofa.ark.spi.model.PluginContext;
import com.alipay.sofa.ark.spi.service.PluginActivator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pres.lnk.sofa.demo.facade.FacadeService;

/**
 * @Author linnankun
 * @Date 2020/12/2
 */
public class Starter implements PluginActivator {
    private final static Logger logger = LoggerFactory.getLogger(Starter.class);

    @Override
    public void start(PluginContext context) {
        System.out.println("plugin start");

        // 发布服务
        context.publishService(FacadeService.class, new FacadeService() {
            @Override
            public String sayHello() {
                return "plugin publish service";
            }
        }, "pluginService");
        logger.info("publish service: {}", PluginService.class.getName());
    }

    @Override
    public void stop(PluginContext context) {
        logger.info("plugin stop");
    }
}
