from django.contrib import admin
from django.urls import include, path

urlpatterns = [
    path('house/', include('house.urls')),
    path('admin/', admin.site.urls),
]