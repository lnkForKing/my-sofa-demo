package pres.lnk.sofa.demo.plugin;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import org.springframework.stereotype.Component;
import pres.lnk.sofa.demo.facade.FacadeService;

/**
 * @Author linnankun
 * @Date 2020/12/16
 */
@Component
@SofaService
public class PluginService implements FacadeService {
    @Override
    public String sayHello() {
        return "I'm plugin";
    }
}
