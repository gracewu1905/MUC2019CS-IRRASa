# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html


# useful for handling different item types with a single interface
from itemadapter import ItemAdapter
import csv

class HousePipeline:
    def process_item(self, item, spider):
        # with open("2.csv","w",encoding="utf-8",newline="") as f:
        #     w=csv.writer(f)
        #     w.writerow(item['name'])
        # f.close()
        return item
