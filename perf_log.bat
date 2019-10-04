logman create counter perf_log2 -cf "C:\PerfLogs\Admin\Counter.txt" -f csv -si 00:00:02
logman start perf_log2
mvn clean test -DsuiteXml=testng.xml
logman stop perf_log2
logman delete perf_log2
