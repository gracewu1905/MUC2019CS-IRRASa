# Define here the models for your scraped items
#
# See documentation in:
# https://docs.scrapy.org/en/latest/topics/items.html

import scrapy

# 名称 面积 租价 房型 位置
class HouseItem(scrapy.Item):
    # define the fields for your item here like:
    name = scrapy.Field()
    area = scrapy.Field()
    price = scrapy.Field()
    house = scrapy.Field()
    location = scrapy.Field()
    # pass
