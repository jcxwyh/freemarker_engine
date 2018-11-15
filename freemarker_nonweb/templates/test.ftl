<#-- freemarker注释，不会显示到前台页面 -->
<#outputformat "HTML"></#outputformat>
你好,${user!"wyh"}<#if user == "jcx">hahahahaha</#if>！你吃了吗？
<#compress >
    ${date?string["yyyy-MM-dd"]}
    <#assign str = "abcdefg">
    ${indexOf("de",str)}

    <@upper>
        asdasdasdas
        ${user}
        lkzp
        AAAA
    </@upper>

    <#assign x=1>
    <@repeat count=4>
        ${x} repeat directive
        <#assign x++>
    </@repeat>
    <@repeat count=4 hr=true>
        repeat directive
    </@repeat>
    <@repeat count=4; cnt>
        ${cnt}.repeat directive
    </@repeat>
</#compress>
<#-- + + + + + + + + + + + + + + + + + + + + + + + + +
    FTLtag:以#开头,如<#if></#if>
            <#if 逻辑表达式>
                <#else>
                <#elseif>
            <#list>
                用法1:<#list 集合 as 元素>
                用法2:<#list 集合>
                        <#items as 元素>
                    </#list>
            <#sep>:定义使用分隔符
                <#sep>,以逗号分割
            <#include "文件uri">
            <#ftl output_format="指定输出格式[HTML,XML]">
            <#assign>定义变量
                <#assign s = "Hello ${user} !">
                [same to]
                <#assign s = "Hello " + user + " !">
            <#import>:导入ftl模板，可以使用定义好的macro
    用户自定义tag:以@开头，如<@box></@box>


    字符串操作：<#assign user="ABCDEFG">
            ${user[1]}取第二个字符                :B
            ${user[2..3]}取索引[2,3]的值          :CD
            ${user[2..<4]}取索引[2,4)的值         :CD
            ${s[2..*3]}取索引2及往后共三个值的值    :CDE
            ${s[2..]}取索引2及往后的值             :CDEFG

    方法调用：
            ?
                ${testString?upper_case}:转大写
                ${testString?html}将特殊字符转html，如& -> &amp;
                ${testString?upper_case?html}方法层级调用
                ${testSequence?size}
                ${testSequence?length}
                ${testSequence?join(", ")}
                ${testSeqence[1]?cap_first}第一个字母大写
            repeat
                ${repeat("重复的东西",重复次数)：${repeat("Foo", 3)} - ->FooFooFoo

    解决null值或返回为void的情况：
            !
                ${mouse!"默认值"}:如果为null就使用!后的默认值，${mouse!}


    自定义macro:
            定义：
                <#macro greet person>
                  <font size="+2">Hello ${person}!</font>
                </#macro>
            使用：
                <@greet person="Fred"/> and <@greet person="Batman"/>
            输出：
                <font size="+2">Hello Fred!</font> and <font size="+2">Hello Batman!</font>

            Nested content：
                <#nested>标记定义，使用时具体填充

     导入ftl模板：
            <#import "模板uri" as 名称>



+ + + + + + + + + + + + + + + + + + + + + + + + + + -->