java_library(
  name = 'elasticsearch',
  srcs = glob(['src/main/java/**/*.java']),
  deps = [
    '//gerrit-antlr:query_exception',
    '//gerrit-extension-api:api',
    '//gerrit-lucene:lucene', # only for LuceneAccountIndex
    '//gerrit-reviewdb:client',
    '//gerrit-reviewdb:server',
    '//gerrit-server:server',
    '//lib:gson',
    '//lib:guava',
    '//lib:gwtorm',
    '//lib:protobuf',
    '//lib/commons:codec',
    '//lib/commons:lang',
    '//lib/elasticsearch:elasticsearch',
    '//lib/elasticsearch:jest',
    '//lib/elasticsearch:jest-common',
    '//lib/guice:guice',
    '//lib/guice:guice-assistedinject',
    '//lib/jgit/org.eclipse.jgit:jgit',
    '//lib/joda:joda-time',
    '//lib/log:api',
    '//lib/lucene:lucene-analyzers-common',
    '//lib/lucene:lucene-core',
  ],
  visibility = ['//visibility:public'],
)

load('//tools/bzl:junit.bzl', 'junit_tests')

junit_tests(
  name = 'elasticsearch_tests',
  tags = ['elastic', 'flaky'],
  srcs = glob(['src/test/java/**/*.java']),
  size = "large",
  deps = [
    ':elasticsearch',
    '//gerrit-extension-api:api',
    '//gerrit-server:server',
    '//gerrit-server:testutil',
    '//gerrit-server:query_tests_code',
    '//lib:gson',
    '//lib:guava',
    '//lib:junit',
    '//lib:truth',
    '//lib/elasticsearch:elasticsearch',
    '//lib/guice:guice',
    '//lib/jgit/org.eclipse.jgit:jgit',
    '//lib/jgit/org.eclipse.jgit.junit:junit',
  ],
  flaky = 1,
)
