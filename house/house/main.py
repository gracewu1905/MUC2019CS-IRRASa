from scrapy import cmdline

cmdline.execute("scrapy crawl house -o 1.csv".split())