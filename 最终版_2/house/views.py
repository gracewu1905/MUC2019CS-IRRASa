from django.shortcuts import render
from .models import House
from .spider.anjuke import *
import urllib.request
import json
def index(request):
    List=[]
    # Dict = {'site': '自强学堂', 'author': '涂伟忠'}
    name1=""
    f=''
    g=0
    # print("*****************"+request.GET['suggestId']+"*******************************")
    if 'suggestId' and 'f' and 'g' in request.GET:
        name1=request.GET['suggestId']
        f = request.GET['f']
        g = request.GET['g']
        house =  House.objects.filter(source_prompt=urllib.request.quote(name1))
        if list(house)==[]:
            data=save(name1)
            data = my_sort(f,data)
            List = data
        else:
            # col_name = ['名称', '面积', '租价', '房型', '位置']
            # house = house.iterator()
            for h in house:
                temp=[]
                temp.append(h.house_name)
                temp.append(h.house_area)
                temp.append(h.house_price)
                temp.append(h.house_type)
                temp.append(h.house_location)
                List.append(temp)
                pass
            List = my_sort(f,List)
            # List = house
    
    return render(request, 'index.html', {
                'List': json.dumps(List),
                # 'Dict': json.dumps(Dict),
                'name1': json.dumps(name1),
                'f': json.dumps(f),
                'g': json.dumps(g)
            })

def map(request):
    # latest_question_list = House.objects.order_by('-pub_date')[:5]
    # context = {'latest_question_list': latest_question_list}
    return render(request, 'map.html')