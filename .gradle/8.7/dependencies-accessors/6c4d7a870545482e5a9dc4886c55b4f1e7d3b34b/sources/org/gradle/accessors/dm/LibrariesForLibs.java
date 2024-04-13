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
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ComLibraryAccessors laccForComLibraryAccessors = new ComLibraryAccessors(owner);
    private final JunitLibraryAccessors laccForJunitLibraryAccessors = new JunitLibraryAccessors(owner);
    private final OrgLibraryAccessors laccForOrgLibraryAccessors = new OrgLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Group of libraries at <b>com</b>
     */
    public ComLibraryAccessors getCom() {
        return laccForComLibraryAccessors;
    }

    /**
     * Group of libraries at <b>junit</b>
     */
    public JunitLibraryAccessors getJunit() {
        return laccForJunitLibraryAccessors;
    }

    /**
     * Group of libraries at <b>org</b>
     */
    public OrgLibraryAccessors getOrg() {
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
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class ComLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleLibraryAccessors laccForComGoogleLibraryAccessors = new ComGoogleLibraryAccessors(owner);

        public ComLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google</b>
         */
        public ComGoogleLibraryAccessors getGoogle() {
            return laccForComGoogleLibraryAccessors;
        }

    }

    public static class ComGoogleLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleJimfsLibraryAccessors laccForComGoogleJimfsLibraryAccessors = new ComGoogleJimfsLibraryAccessors(owner);
        private final ComGoogleTestingLibraryAccessors laccForComGoogleTestingLibraryAccessors = new ComGoogleTestingLibraryAccessors(owner);
        private final ComGoogleTruthLibraryAccessors laccForComGoogleTruthLibraryAccessors = new ComGoogleTruthLibraryAccessors(owner);

        public ComGoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.jimfs</b>
         */
        public ComGoogleJimfsLibraryAccessors getJimfs() {
            return laccForComGoogleJimfsLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.google.testing</b>
         */
        public ComGoogleTestingLibraryAccessors getTesting() {
            return laccForComGoogleTestingLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.google.truth</b>
         */
        public ComGoogleTruthLibraryAccessors getTruth() {
            return laccForComGoogleTruthLibraryAccessors;
        }

    }

    public static class ComGoogleJimfsLibraryAccessors extends SubDependencyFactory {

        public ComGoogleJimfsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jimfs</b> with <b>com.google.jimfs:jimfs</b> coordinates and
         * with version reference <b>com.google.jimfs.jimfs</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJimfs() {
            return create("com.google.jimfs.jimfs");
        }

    }

    public static class ComGoogleTestingLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleTestingCompileLibraryAccessors laccForComGoogleTestingCompileLibraryAccessors = new ComGoogleTestingCompileLibraryAccessors(owner);

        public ComGoogleTestingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.testing.compile</b>
         */
        public ComGoogleTestingCompileLibraryAccessors getCompile() {
            return laccForComGoogleTestingCompileLibraryAccessors;
        }

    }

    public static class ComGoogleTestingCompileLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleTestingCompileCompileLibraryAccessors laccForComGoogleTestingCompileCompileLibraryAccessors = new ComGoogleTestingCompileCompileLibraryAccessors(owner);

        public ComGoogleTestingCompileLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.testing.compile.compile</b>
         */
        public ComGoogleTestingCompileCompileLibraryAccessors getCompile() {
            return laccForComGoogleTestingCompileCompileLibraryAccessors;
        }

    }

    public static class ComGoogleTestingCompileCompileLibraryAccessors extends SubDependencyFactory {

        public ComGoogleTestingCompileCompileLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>testing</b> with <b>com.google.testing.compile:compile-testing</b> coordinates and
         * with version reference <b>com.google.testing.compile.compile.testing</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTesting() {
            return create("com.google.testing.compile.compile.testing");
        }

    }

    public static class ComGoogleTruthLibraryAccessors extends SubDependencyFactory {

        public ComGoogleTruthLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>truth</b> with <b>com.google.truth:truth</b> coordinates and
         * with version reference <b>com.google.truth.truth</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTruth() {
            return create("com.google.truth.truth");
        }

    }

    public static class JunitLibraryAccessors extends SubDependencyFactory {

        public JunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>junit</b> with <b>junit:junit</b> coordinates and
         * with version reference <b>junit.junit</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit() {
            return create("junit.junit");
        }

    }

    public static class OrgLibraryAccessors extends SubDependencyFactory {
        private final OrgEclipseLibraryAccessors laccForOrgEclipseLibraryAccessors = new OrgEclipseLibraryAccessors(owner);
        private final OrgMockitoLibraryAccessors laccForOrgMockitoLibraryAccessors = new OrgMockitoLibraryAccessors(owner);

        public OrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.eclipse</b>
         */
        public OrgEclipseLibraryAccessors getEclipse() {
            return laccForOrgEclipseLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.mockito</b>
         */
        public OrgMockitoLibraryAccessors getMockito() {
            return laccForOrgMockitoLibraryAccessors;
        }

    }

    public static class OrgEclipseLibraryAccessors extends SubDependencyFactory {
        private final OrgEclipseJdtLibraryAccessors laccForOrgEclipseJdtLibraryAccessors = new OrgEclipseJdtLibraryAccessors(owner);

        public OrgEclipseLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.eclipse.jdt</b>
         */
        public OrgEclipseJdtLibraryAccessors getJdt() {
            return laccForOrgEclipseJdtLibraryAccessors;
        }

    }

    public static class OrgEclipseJdtLibraryAccessors extends SubDependencyFactory {
        private final OrgEclipseJdtCoreLibraryAccessors laccForOrgEclipseJdtCoreLibraryAccessors = new OrgEclipseJdtCoreLibraryAccessors(owner);

        public OrgEclipseJdtLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.eclipse.jdt.core</b>
         */
        public OrgEclipseJdtCoreLibraryAccessors getCore() {
            return laccForOrgEclipseJdtCoreLibraryAccessors;
        }

    }

    public static class OrgEclipseJdtCoreLibraryAccessors extends SubDependencyFactory {
        private final OrgEclipseJdtCoreCompilerLibraryAccessors laccForOrgEclipseJdtCoreCompilerLibraryAccessors = new OrgEclipseJdtCoreCompilerLibraryAccessors(owner);

        public OrgEclipseJdtCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.eclipse.jdt.core.compiler</b>
         */
        public OrgEclipseJdtCoreCompilerLibraryAccessors getCompiler() {
            return laccForOrgEclipseJdtCoreCompilerLibraryAccessors;
        }

    }

    public static class OrgEclipseJdtCoreCompilerLibraryAccessors extends SubDependencyFactory {

        public OrgEclipseJdtCoreCompilerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ecj</b> with <b>org.eclipse.jdt.core.compiler:ecj</b> coordinates and
         * with version reference <b>org.eclipse.jdt.core.compiler.ecj</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getEcj() {
            return create("org.eclipse.jdt.core.compiler.ecj");
        }

    }

    public static class OrgMockitoLibraryAccessors extends SubDependencyFactory {
        private final OrgMockitoMockitoLibraryAccessors laccForOrgMockitoMockitoLibraryAccessors = new OrgMockitoMockitoLibraryAccessors(owner);

        public OrgMockitoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.mockito.mockito</b>
         */
        public OrgMockitoMockitoLibraryAccessors getMockito() {
            return laccForOrgMockitoMockitoLibraryAccessors;
        }

    }

    public static class OrgMockitoMockitoLibraryAccessors extends SubDependencyFactory {

        public OrgMockitoMockitoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.mockito:mockito-core</b> coordinates and
         * with version reference <b>org.mockito.mockito.core</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
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

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
