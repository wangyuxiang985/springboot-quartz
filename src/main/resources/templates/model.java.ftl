package ${package.Controller};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * ${table.comment}
 * </p>
 *
 * @author ${author}
 * @since 2018-04-02 <#--${date} -->
 */
<#if entityLombokModel>
@Data
@NoArgsConstructor
@AllArgsConstructor
<#if superEntityClass??>
@EqualsAndHashCode(callSuper = true)
</#if>
@Accessors(chain = true)
</#if>
@ApiModel(description = "${table.comment}")
<#if superEntityClass??>
public class ${entity} extends ${superEntityClass}<#if activeRecord><${entity}></#if> {
<#elseif activeRecord>
public class ${entity} extends Model<${entity}> {
<#else>
public class ${entity}Vo {
</#if>

<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
<#if field.keyFlag>
<#assign keyPropertyName="${field.propertyName}"/>
</#if>

<#if field.comment!?length gt 0>
    /** ${field.comment} */
    @ApiModelProperty(value = "${field.comment}", required = true)
</#if>
    private ${field.propertyType} ${field.propertyName};
</#list>
<#------------  END 字段循环遍历  ---------->

}