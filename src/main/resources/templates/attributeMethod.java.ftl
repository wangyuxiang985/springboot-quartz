<#-- ----------  BEGIN 字段循环遍历  ---------->
        // ${table.comment}
<#list table.fields as field>
        ${entity}.set${field.capitalName}(${entity}Vo.get${field.capitalName}()); // ${field.comment}
</#list>
<#------------  END 字段循环遍历  ---------->

<#-- ----------  BEGIN 字段循环遍历  ---------->
        // ${table.comment}
<#list table.fields as field>
        ${entity}.get${field.capitalName}(); // ${field.comment}
</#list>
<#------------  END 字段循环遍历  ---------->