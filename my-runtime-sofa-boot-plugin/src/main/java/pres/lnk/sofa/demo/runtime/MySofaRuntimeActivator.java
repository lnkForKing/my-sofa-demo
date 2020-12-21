package pres.lnk.sofa.demo.runtime;

import com.alipay.sofa.ark.spi.model.PluginContext;
import com.alipay.sofa.ark.spi.service.PluginActivator;
import com.alipay.sofa.ark.spi.service.event.EventAdminService;
import com.alipay.sofa.runtime.SofaBizHealthCheckEventHandler;
import com.alipay.sofa.runtime.SofaBizUninstallEventHandler;
import com.alipay.sofa.runtime.invoke.DynamicJvmServiceProxyFinder;
import com.alipay.sofa.runtime.spring.FinishStartupEventHandler;

/**
 * @Author linnankun
 * @Date 2020/12/18
 */
public class MySofaRuntimeActivator implements PluginActivator {
    @Override
    public void start(PluginContext context) {
        registerEventHandler(context);
        context.publishService(DynamicJvmServiceProxyFinder.class,
            DynamicJvmServiceProxyFinder.getDynamicJvmServiceProxyFinder());
    }

    private void registerEventHandler(final PluginContext context) {
        EventAdminService eventAdminService = context.referenceService(EventAdminService.class)
            .getService();
        eventAdminService.register(new SofaBizUninstallEventHandler());
        eventAdminService.register(new SofaBizHealthCheckEventHandler());
        eventAdminService.register(new FinishStartupEventHandler());
    }

    @Override
    public void stop(PluginContext context) {
        // no op
    }
}
