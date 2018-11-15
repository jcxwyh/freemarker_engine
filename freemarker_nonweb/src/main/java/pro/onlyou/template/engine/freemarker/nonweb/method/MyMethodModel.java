package pro.onlyou.template.engine.freemarker.nonweb.method;

import freemarker.template.SimpleNumber;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

import java.util.List;
import java.util.Objects;

/**
 * 自定义可在模板中使用的方法
 */
public class MyMethodModel implements TemplateMethodModel {
    @Override
    public Object exec(List arguments) throws TemplateModelException {
        if(Objects.isNull(arguments) && arguments.size() != 2){
            throw new TemplateModelException("参数不对！");
        }
        return new SimpleNumber(
                ((String) arguments.get(1)).indexOf((String)(arguments.get(0)))
        );
    }
}
