package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibsInPluginsBlock extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ComLibraryAccessors laccForComLibraryAccessors = new ComLibraryAccessors(owner);
    private final JunitLibraryAccessors laccForJunitLibraryAccessors = new JunitLibraryAccessors(owner);
    private final OrgLibraryAccessors laccForOrgLibraryAccessors = new OrgLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibsInPluginsBlock(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Group of libraries at <b>com</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public ComLibraryAccessors getCom() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return laccForComLibraryAccessors;
    }

    /**
     * Group of libraries at <b>junit</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public JunitLibraryAccessors getJunit() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return laccForJunitLibraryAccessors;
    }

    /**
     * Group of libraries at <b>org</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public OrgLibraryAccessors getOrg() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return laccForOrgLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public BundleAccessors getBundles() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleLibraryAccessors laccForComGoogleLibraryAccessors = new ComGoogleLibraryAccessors(owner);

        public ComLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGoogleLibraryAccessors getGoogle() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGoogleLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGoogleLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleJimfsLibraryAccessors laccForComGoogleJimfsLibraryAccessors = new ComGoogleJimfsLibraryAccessors(owner);
        private final ComGoogleTestingLibraryAccessors laccForComGoogleTestingLibraryAccessors = new ComGoogleTestingLibraryAccessors(owner);
        private final ComGoogleTruthLibraryAccessors laccForComGoogleTruthLibraryAccessors = new ComGoogleTruthLibraryAccessors(owner);

        public ComGoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.jimfs</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGoogleJimfsLibraryAccessors getJimfs() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGoogleJimfsLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.google.testing</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGoogleTestingLibraryAccessors getTesting() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGoogleTestingLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.google.truth</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGoogleTruthLibraryAccessors getTruth() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGoogleTruthLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGoogleJimfsLibraryAccessors extends SubDependencyFactory {

        public ComGoogleJimfsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jimfs</b> with <b>com.google.jimfs:jimfs</b> coordinates and
         * with version reference <b>com.google.jimfs.jimfs</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getJimfs() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("com.google.jimfs.jimfs");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGoogleTestingLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleTestingCompileLibraryAccessors laccForComGoogleTestingCompileLibraryAccessors = new ComGoogleTestingCompileLibraryAccessors(owner);

        public ComGoogleTestingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.testing.compile</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGoogleTestingCompileLibraryAccessors getCompile() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGoogleTestingCompileLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGoogleTestingCompileLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleTestingCompileCompileLibraryAccessors laccForComGoogleTestingCompileCompileLibraryAccessors = new ComGoogleTestingCompileCompileLibraryAccessors(owner);

        public ComGoogleTestingCompileLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.testing.compile.compile</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGoogleTestingCompileCompileLibraryAccessors getCompile() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGoogleTestingCompileCompileLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGoogleTestingCompileCompileLibraryAccessors extends SubDependencyFactory {

        public ComGoogleTestingCompileCompileLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>testing</b> with <b>com.google.testing.compile:compile-testing</b> coordinates and
         * with version reference <b>com.google.testing.compile.compile.testing</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getTesting() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("com.google.testing.compile.compile.testing");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGoogleTruthLibraryAccessors extends SubDependencyFactory {

        public ComGoogleTruthLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>truth</b> with <b>com.google.truth:truth</b> coordinates and
         * with version reference <b>com.google.truth.truth</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getTruth() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("com.google.truth.truth");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JunitLibraryAccessors extends SubDependencyFactory {

        public JunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>junit</b> with <b>junit:junit</b> coordinates and
         * with version reference <b>junit.junit</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getJunit() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("junit.junit");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgLibraryAccessors extends SubDependencyFactory {
        private final OrgEclipseLibraryAccessors laccForOrgEclipseLibraryAccessors = new OrgEclipseLibraryAccessors(owner);
        private final OrgMockitoLibraryAccessors laccForOrgMockitoLibraryAccessors = new OrgMockitoLibraryAccessors(owner);

        public OrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.eclipse</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgEclipseLibraryAccessors getEclipse() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgEclipseLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.mockito</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgMockitoLibraryAccessors getMockito() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgMockitoLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgEclipseLibraryAccessors extends SubDependencyFactory {
        private final OrgEclipseJdtLibraryAccessors laccForOrgEclipseJdtLibraryAccessors = new OrgEclipseJdtLibraryAccessors(owner);

        public OrgEclipseLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.eclipse.jdt</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgEclipseJdtLibraryAccessors getJdt() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgEclipseJdtLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgEclipseJdtLibraryAccessors extends SubDependencyFactory {
        private final OrgEclipseJdtCoreLibraryAccessors laccForOrgEclipseJdtCoreLibraryAccessors = new OrgEclipseJdtCoreLibraryAccessors(owner);

        public OrgEclipseJdtLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.eclipse.jdt.core</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgEclipseJdtCoreLibraryAccessors getCore() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgEclipseJdtCoreLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgEclipseJdtCoreLibraryAccessors extends SubDependencyFactory {
        private final OrgEclipseJdtCoreCompilerLibraryAccessors laccForOrgEclipseJdtCoreCompilerLibraryAccessors = new OrgEclipseJdtCoreCompilerLibraryAccessors(owner);

        public OrgEclipseJdtCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.eclipse.jdt.core.compiler</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgEclipseJdtCoreCompilerLibraryAccessors getCompiler() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgEclipseJdtCoreCompilerLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgEclipseJdtCoreCompilerLibraryAccessors extends SubDependencyFactory {

        public OrgEclipseJdtCoreCompilerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ecj</b> with <b>org.eclipse.jdt.core.compiler:ecj</b> coordinates and
         * with version reference <b>org.eclipse.jdt.core.compiler.ecj</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getEcj() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.eclipse.jdt.core.compiler.ecj");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgMockitoLibraryAccessors extends SubDependencyFactory {
        private final OrgMockitoMockitoLibraryAccessors laccForOrgMockitoMockitoLibraryAccessors = new OrgMockitoMockitoLibraryAccessors(owner);

        public OrgMockitoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.mockito.mockito</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgMockitoMockitoLibraryAccessors getMockito() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgMockitoMockitoLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgMockitoMockitoLibraryAccessors extends SubDependencyFactory {

        public OrgMockitoMockitoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.mockito:mockito-core</b> coordinates and
         * with version reference <b>org.mockito.mockito.core</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCore() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.mockito.mockito.core");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final ComVersionAccessors vaccForComVersionAccessors = new ComVersionAccessors(providers, config);
        private final JunitVersionAccessors vaccForJunitVersionAccessors = new JunitVersionAccessors(providers, config);
        private final OrgVersionAccessors vaccForOrgVersionAccessors = new OrgVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com</b>
         */
        public ComVersionAccessors getCom() {
            return vaccForComVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.junit</b>
         */
        public JunitVersionAccessors getJunit() {
            return vaccForJunitVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org</b>
         */
        public OrgVersionAccessors getOrg() {
            return vaccForOrgVersionAccessors;
        }

    }

    public static class ComVersionAccessors extends VersionFactory  {

        private final ComGoogleVersionAccessors vaccForComGoogleVersionAccessors = new ComGoogleVersionAccessors(providers, config);
        public ComVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google</b>
         */
        public ComGoogleVersionAccessors getGoogle() {
            return vaccForComGoogleVersionAccessors;
        }

    }

    public static class ComGoogleVersionAccessors extends VersionFactory  {

        private final ComGoogleJimfsVersionAccessors vaccForComGoogleJimfsVersionAccessors = new ComGoogleJimfsVersionAccessors(providers, config);
        private final ComGoogleTestingVersionAccessors vaccForComGoogleTestingVersionAccessors = new ComGoogleTestingVersionAccessors(providers, config);
        private final ComGoogleTruthVersionAccessors vaccForComGoogleTruthVersionAccessors = new ComGoogleTruthVersionAccessors(providers, config);
        public ComGoogleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.jimfs</b>
         */
        public ComGoogleJimfsVersionAccessors getJimfs() {
            return vaccForComGoogleJimfsVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.google.testing</b>
         */
        public ComGoogleTestingVersionAccessors getTesting() {
            return vaccForComGoogleTestingVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.google.truth</b>
         */
        public ComGoogleTruthVersionAccessors getTruth() {
            return vaccForComGoogleTruthVersionAccessors;
        }

    }

    public static class ComGoogleJimfsVersionAccessors extends VersionFactory  {

        public ComGoogleJimfsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.google.jimfs.jimfs</b> with value <b>1.3.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJimfs() { return getVersion("com.google.jimfs.jimfs"); }

    }

    public static class ComGoogleTestingVersionAccessors extends VersionFactory  {

        private final ComGoogleTestingCompileVersionAccessors vaccForComGoogleTestingCompileVersionAccessors = new ComGoogleTestingCompileVersionAccessors(providers, config);
        public ComGoogleTestingVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.testing.compile</b>
         */
        public ComGoogleTestingCompileVersionAccessors getCompile() {
            return vaccForComGoogleTestingCompileVersionAccessors;
        }

    }

    public static class ComGoogleTestingCompileVersionAccessors extends VersionFactory  {

        private final ComGoogleTestingCompileCompileVersionAccessors vaccForComGoogleTestingCompileCompileVersionAccessors = new ComGoogleTestingCompileCompileVersionAccessors(providers, config);
        public ComGoogleTestingCompileVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.testing.compile.compile</b>
         */
        public ComGoogleTestingCompileCompileVersionAccessors getCompile() {
            return vaccForComGoogleTestingCompileCompileVersionAccessors;
        }

    }

    public static class ComGoogleTestingCompileCompileVersionAccessors extends VersionFactory  {

        public ComGoogleTestingCompileCompileVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.google.testing.compile.compile.testing</b> with value <b>0.21.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTesting() { return getVersion("com.google.testing.compile.compile.testing"); }

    }

    public static class ComGoogleTruthVersionAccessors extends VersionFactory  {

        public ComGoogleTruthVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.google.truth.truth</b> with value <b>1.4.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTruth() { return getVersion("com.google.truth.truth"); }

    }

    public static class JunitVersionAccessors extends VersionFactory  {

        public JunitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>junit.junit</b> with value <b>4.13.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJunit() { return getVersion("junit.junit"); }

    }

    public static class OrgVersionAccessors extends VersionFactory  {

        private final OrgEclipseVersionAccessors vaccForOrgEclipseVersionAccessors = new OrgEclipseVersionAccessors(providers, config);
        private final OrgMockitoVersionAccessors vaccForOrgMockitoVersionAccessors = new OrgMockitoVersionAccessors(providers, config);
        public OrgVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.eclipse</b>
         */
        public OrgEclipseVersionAccessors getEclipse() {
            return vaccForOrgEclipseVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.mockito</b>
         */
        public OrgMockitoVersionAccessors getMockito() {
            return vaccForOrgMockitoVersionAccessors;
        }

    }

    public static class OrgEclipseVersionAccessors extends VersionFactory  {

        private final OrgEclipseJdtVersionAccessors vaccForOrgEclipseJdtVersionAccessors = new OrgEclipseJdtVersionAccessors(providers, config);
        public OrgEclipseVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.eclipse.jdt</b>
         */
        public OrgEclipseJdtVersionAccessors getJdt() {
            return vaccForOrgEclipseJdtVersionAccessors;
        }

    }

    public static class OrgEclipseJdtVersionAccessors extends VersionFactory  {

        private final OrgEclipseJdtCoreVersionAccessors vaccForOrgEclipseJdtCoreVersionAccessors = new OrgEclipseJdtCoreVersionAccessors(providers, config);
        public OrgEclipseJdtVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.eclipse.jdt.core</b>
         */
        public OrgEclipseJdtCoreVersionAccessors getCore() {
            return vaccForOrgEclipseJdtCoreVersionAccessors;
        }

    }

    public static class OrgEclipseJdtCoreVersionAccessors extends VersionFactory  {

        private final OrgEclipseJdtCoreCompilerVersionAccessors vaccForOrgEclipseJdtCoreCompilerVersionAccessors = new OrgEclipseJdtCoreCompilerVersionAccessors(providers, config);
        public OrgEclipseJdtCoreVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.eclipse.jdt.core.compiler</b>
         */
        public OrgEclipseJdtCoreCompilerVersionAccessors getCompiler() {
            return vaccForOrgEclipseJdtCoreCompilerVersionAccessors;
        }

    }

    public static class OrgEclipseJdtCoreCompilerVersionAccessors extends VersionFactory  {

        public OrgEclipseJdtCoreCompilerVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.eclipse.jdt.core.compiler.ecj</b> with value <b>4.6.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getEcj() { return getVersion("org.eclipse.jdt.core.compiler.ecj"); }

    }

    public static class OrgMockitoVersionAccessors extends VersionFactory  {

        private final OrgMockitoMockitoVersionAccessors vaccForOrgMockitoMockitoVersionAccessors = new OrgMockitoMockitoVersionAccessors(providers, config);
        public OrgMockitoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.mockito.mockito</b>
         */
        public OrgMockitoMockitoVersionAccessors getMockito() {
            return vaccForOrgMockitoMockitoVersionAccessors;
        }

    }

    public static class OrgMockitoMockitoVersionAccessors extends VersionFactory  {

        public OrgMockitoMockitoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.mockito.mockito.core</b> with value <b>4.11.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCore() { return getVersion("org.mockito.mockito.core"); }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
