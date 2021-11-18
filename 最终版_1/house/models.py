from django.db import models
from django.db.models.fields.related import ForeignKey

import house
class House(models.Model):
    # 房屋名称
    house_name = models.CharField(max_length = 200 , verbose_name = u"房屋名称")
    # 房屋面积
    house_area = models.IntegerField(verbose_name = u"房屋面积")
    # 租价
    house_price = models.IntegerField(verbose_name = u"租价")
    # 房型
    house_type = models.CharField(max_length = 200 , verbose_name = u"房型")
    # 位置
    house_location = models.CharField(max_length = 200 , verbose_name = u"位置")
    def __str__(self) -> str:
        return "house_name:{},\thouse_area:{},\thouse_price:{},\thouse_type:{},\thouse_location:{}".format(self.house_name,self.house_area,self.house_price,self.house_type,self.house_location)
