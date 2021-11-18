from django.shortcuts import render
from .models import House
from .spider.anjuke import *
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
        data=save(name1)
        data = my_sort(f,data)
        List = data
    
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