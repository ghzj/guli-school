package io.github.ghzj.generator.entity.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;

/**
 * @author ghzj
 * @date 2021/1/15 21:25
 */
@ConfigurationProperties(
        prefix = "ghxj.generator"
)
public class GeneratorProperties {
    private String templateClassScanPackagePath;
    private String templateDirPath;
    private String mainPath;
    private String packagePath;
    private String moduleName;
    private String author;
    private String email;
    private String[] tablePrefix;
    private String baseErrorCode;
    private String tableSchema;

    public String getTemplateClassScanPackagePath() {
        return templateClassScanPackagePath;
    }

    public void setTemplateClassScanPackagePath(String templateClassScanPackagePath) {
        this.templateClassScanPackagePath = templateClassScanPackagePath;
    }

    public String getTemplateDirPath() {
        return templateDirPath;
    }

    public void setTemplateDirPath(String templateDirPath) {
        this.templateDirPath = templateDirPath;
    }

    public String getMainPath() {
        return mainPath;
    }

    public void setMainPath(String mainPath) {
        this.mainPath = mainPath;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getTablePrefix() {
        return tablePrefix;
    }

    public void setTablePrefix(String[] tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    public String getBaseErrorCode() {
        return baseErrorCode;
    }

    public void setBaseErrorCode(String baseErrorCode) {
        this.baseErrorCode = baseErrorCode;
    }

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    @Override
    public String toString() {
        return "GeneratorProperties{" +
                "templateClassScanPackagePath='" + templateClassScanPackagePath + '\'' +
                ", templateDirPath='" + templateDirPath + '\'' +
                ", mainPath='" + mainPath + '\'' +
                ", packagePath='" + packagePath + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", author='" + author + '\'' +
                ", email='" + email + '\'' +
                ", tablePrefix=" + Arrays.toString(tablePrefix) +
                ", baseErrorCode='" + baseErrorCode + '\'' +
                ", tableSchema='" + tableSchema + '\'' +
                '}';
    }
}
