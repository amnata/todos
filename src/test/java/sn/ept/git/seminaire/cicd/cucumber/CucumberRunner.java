<<<<<<< HEAD
=======
////package sn.ept.git.seminaire.cicd.cucumber;
////
////import org.junit.platform.suite.api.*;
////
////
////@Suite(failIfNoTests = false)
////@IncludeEngines(value = {"cucumber"})
////@SelectClasspathResource("features")
////@ConfigurationParameters({
////        @ConfigurationParameter(key= CucumberRunner.GLUE_PROPERTY, value = CucumberRunner.GLUE_PROPERTY_VALUE),
////        @ConfigurationParameter(key= CucumberRunner.NAMING_STRATEGY, value = CucumberRunner.NAMING_STRATEGY_VALUE),
////        @ConfigurationParameter(key= CucumberRunner.PLUGIN_PROPERTY_NAME, value = CucumberRunner.PLUGIN_PROPERTY_NAME_VALUE),
////        @ConfigurationParameter(key= CucumberRunner.PUBLISH_QUIET, value = CucumberRunner.PUBLISH_QUIET_VALUE)
////})public class CucumberRunner {
////        public static final String GLUE_PROPERTY="cucumber.glue";
////        public static final String GLUE_PROPERTY_VALUE="sn.ept.git.seminaire.cicd.cucumber";
////
////        public static final String NAMING_STRATEGY="cucumber.junit-platform.naming.strategy";
////        public static final String NAMING_STRATEGY_VALUE="long";
////
////        public static final String PUBLISH_QUIET="cucumber.publish.quiet";
////        public static final String PUBLISH_QUIET_VALUE="false";
////
////        public static final String PLUGIN_PROPERTY_NAME="cucumber.plugin";
////        public static final String PLUGIN_PROPERTY_NAME_VALUE="pretty, html:target/cucumber-report/cucumber-html-report.html, json:target/cucumber-report/cucumber-json-report.json";
////}
//
//
//package sn.ept.git.seminaire.cicd.cucumber;
//
//import org.junit.platform.suite.api.*;
//
//@Suite(failIfNoTests = false)
//@IncludeEngines(value = {"cucumber"})
//@SelectClasspathResource("features/tags")
//@ConfigurationParameters({
//        @ConfigurationParameter(key = TagCucumberRunner.GLUE_PROPERTY, value = TagCucumberRunner.GLUE_PROPERTY_VALUE),
//        @ConfigurationParameter(key = TagCucumberRunner.NAMING_STRATEGY, value = TagCucumberRunner.NAMING_STRATEGY_VALUE),
//        @ConfigurationParameter(key = TagCucumberRunner.PLUGIN_PROPERTY_NAME, value = TagCucumberRunner.PLUGIN_PROPERTY_NAME_VALUE),
//        @ConfigurationParameter(key = TagCucumberRunner.PUBLISH_QUIET, value = TagCucumberRunner.PUBLISH_QUIET_VALUE),
//        @ConfigurationParameter(key = TagCucumberRunner.FILTER_TAGS, value = TagCucumberRunner.FILTER_TAGS_VALUE)
//})
////public class TagCucumberRunner {
////    
////    public static final String GLUE_PROPERTY = "cucumber.glue";
////    public static final String GLUE_PROPERTY_VALUE = "sn.ept.git.seminaire.cicd.cucumber.definitions";
////    
////    public static final String NAMING_STRATEGY = "cucumber.junit-platform.naming.strategy";
////    public static final String NAMING_STRATEGY_VALUE = "long";
////    
////    public static final String PUBLISH_QUIET = "cucumber.publish.quiet";
////    public static final String PUBLISH_QUIET_VALUE = "false";
////    
////    public static final String PLUGIN_PROPERTY_NAME = "cucumber.plugin";
////    public static final String PLUGIN_PROPERTY_NAME_VALUE = "pretty, html:target/cucumber-report/tags/cucumber-html-report.html, json:target/cucumber-report/tags/cucumber-json-report.json, junit:target/cucumber-report/tags/cucumber-junit-report.xml";
////    
////    public static final String FILTER_TAGS = "cucumber.filter.tags";
////    public static final String FILTER_TAGS_VALUE = "@tag";
////}


>>>>>>> test-ci-pr
package sn.ept.git.seminaire.cicd.cucumber;

import org.junit.platform.suite.api.*;

<<<<<<< HEAD

=======
>>>>>>> test-ci-pr
@Suite(failIfNoTests = false)
@IncludeEngines(value = {"cucumber"})
@SelectClasspathResource("features")
@ConfigurationParameters({
<<<<<<< HEAD
        @ConfigurationParameter(key= CucumberRunner.GLUE_PROPERTY, value = CucumberRunner.GLUE_PROPERTY_VALUE),
        @ConfigurationParameter(key= CucumberRunner.NAMING_STRATEGY, value = CucumberRunner.NAMING_STRATEGY_VALUE),
        @ConfigurationParameter(key= CucumberRunner.PLUGIN_PROPERTY_NAME, value = CucumberRunner.PLUGIN_PROPERTY_NAME_VALUE),
        @ConfigurationParameter(key= CucumberRunner.PUBLISH_QUIET, value = CucumberRunner.PUBLISH_QUIET_VALUE)
})public class CucumberRunner {
        public static final String GLUE_PROPERTY="cucumber.glue";
        public static final String GLUE_PROPERTY_VALUE="sn.ept.git.seminaire.cicd.cucumber";

        public static final String NAMING_STRATEGY="cucumber.junit-platform.naming.strategy";
        public static final String NAMING_STRATEGY_VALUE="long";

        public static final String PUBLISH_QUIET="cucumber.publish.quiet";
        public static final String PUBLISH_QUIET_VALUE="false";

        public static final String PLUGIN_PROPERTY_NAME="cucumber.plugin";
        public static final String PLUGIN_PROPERTY_NAME_VALUE="pretty, html:target/cucumber-report/cucumber-html-report.html, json:target/cucumber-report/cucumber-json-report.json";
=======
        @ConfigurationParameter(key = CucumberRunner.GLUE_PROPERTY, value = CucumberRunner.GLUE_PROPERTY_VALUE),
        @ConfigurationParameter(key = CucumberRunner.NAMING_STRATEGY, value = CucumberRunner.NAMING_STRATEGY_VALUE),
        @ConfigurationParameter(key = CucumberRunner.PLUGIN_PROPERTY_NAME, value = CucumberRunner.PLUGIN_PROPERTY_NAME_VALUE),
        @ConfigurationParameter(key = CucumberRunner.PUBLISH_QUIET, value = CucumberRunner.PUBLISH_QUIET_VALUE)
})
public class CucumberRunner {
    
    public static final String GLUE_PROPERTY = "cucumber.glue";
    public static final String GLUE_PROPERTY_VALUE = "sn.ept.git.seminaire.cicd.cucumber.definitions";
    
    public static final String NAMING_STRATEGY = "cucumber.junit-platform.naming.strategy";
    public static final String NAMING_STRATEGY_VALUE = "long";
    
    public static final String PUBLISH_QUIET = "cucumber.publish.quiet";
    public static final String PUBLISH_QUIET_VALUE = "false";
    
    public static final String PLUGIN_PROPERTY_NAME = "cucumber.plugin";
    public static final String PLUGIN_PROPERTY_NAME_VALUE = "pretty, html:target/cucumber-report/cucumber-html-report.html, json:target/cucumber-report/cucumber-json-report.json";
>>>>>>> test-ci-pr
}