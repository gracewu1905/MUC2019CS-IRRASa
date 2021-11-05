import scrapy
class HouseScrapy(scrapy.spiders.Spider):
    name = "house"
    # allowed_domains="bj.5i5j.com/zufang"
    start_urls=["https://bj.5i5j.com/zufang/"]
    for i in range(1,101):
        start_urls.append("https://bj.5i5j.com/zufang/n{}".format(i))
    def parse(self,response):
        for li in response.xpath('//ul[@class ="pList"] // li'):
            name=li.xpath('div[@class="listCon"]/h3[@class="listTit"]/a/text()').extract()
            temp =li.xpath('div[@class="listCon"]/div[@class="listX"]/p'
                           '/text()').extract_first()
            area=str(temp).split("  ·  ")[1]
            price =li.xpath('div[@class="listCon"]/div[@class="listX"]/div'
                            '[@class="jia"]/p[@class="redC"]/strong/text()').extract()
            house =str(temp).split("  ·  ")[0]
            # .replace('  ·  ')[0]
            location =li.xpath('div[@class="listCon"]/div[@class="listX"]/p'
                               '/a/text()').extract()
            print("******"+house + "**************"+area+"**************8")
            yield {
                "名称":name,
                "面积":area,
                "租价":price,
                "房型":house,
                "位置":location
            }



    # 名称 面积 租价 房型 位置

        # name = scrapy.Field()
        # area = scrapy.Field()
        # price = scrapy.Field()
        # house = scrapy.Field()
        # location = scrapy.Field()
        # pass
