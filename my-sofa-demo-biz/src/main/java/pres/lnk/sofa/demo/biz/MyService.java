package pres.lnk.sofa.demo.biz;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import org.springframework.stereotype.Component;
import pres.lnk.sofa.demo.facade.FacadeService;

/**
 * @Author linnankun
 * @Date 2020/12/16
 */
@Component
@SofaService(uniqueId = "masterService")
public class MyService implements FacadeService {
    @Override
    public String sayHello() {
        return "is master";
    }
}
