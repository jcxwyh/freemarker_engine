package pro.onlyou.template.engine.freemarker.nonweb.directive;

import freemarker.core.Environment;
import freemarker.template.*;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * 实现自己的一个自定义标签处理器
 */

public class MyDirective implements TemplateDirectiveModel {
    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        if(!params.isEmpty()){
            throw new TemplateModelException("参数不正确");
        }
        if(loopVars.length != 0){
            throw new TemplateModelException("Directive不允许loopVars");
        }
        if(body != null){
            body.render(new UppercaseFilterWriter(env.getOut()));
        }else{
            throw new RuntimeException("missing body");
        }
    }

    private class UppercaseFilterWriter extends Writer{

        private final Writer writer;

        UppercaseFilterWriter(Writer writer){
            this.writer = writer;
        }

        @Override
        public void write(char[] cbuf, int off, int len) throws IOException {
            char[] transform = new char[len];
            for(int i = 0;i < len;i ++){
                transform[i] = Character.toUpperCase(cbuf[i + off]);
            }
            writer.write(transform);
        }

        @Override
        public void flush() throws IOException {
            writer.flush();
        }

        @Override
        public void close() throws IOException {
            writer.close();
        }
    }
}
