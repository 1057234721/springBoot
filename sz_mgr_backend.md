title: 深研管理后台接口
------------------------

一、统计分析
============

## 1.  端口数据
### 1 查询端口数据所需信息
```
POST  /ota/stat/outlet/query_port_data_need_info
请求参数：
{
    "model":"-1",// 型号，-1代表"全部"
    "hardware_version":"-1",// 硬件版本号，-1代表"全部"
}

返回示例:
{
    "result": {
        "models": [ // 型号名称和ID
            {
            "str_id":"",
            "str_val":""
            }
        ],
        "hw_vers": [ // 硬件版本号名称和ID
            {
            "str_id": "",
            "str_val": ""
            }
        ],
        "fw_vers": [ // 固件版本号名称和ID
            {
            "str_id": "",
            "str_val": ""
            }
        ],
        "ret_code": 200,
        "ret_msg": "成功",
    },
    "err_code": 200,
    "err_msg": "成功",
}
```
### 2 端口使用分布
```
POST  /ota/stat/outlet/query_port_data
请求参数:
{
    "model":"", // 型号名称
    "hw_ver":"", // 硬件版本号名称
    "fw_ver":"", // 固件版本号名称
    "start_date":"2017/12/18", // 起始日期
    "end_date":"2017/12/20" // 结束日期
}

返回示例：
{
    "result": {
        "date_name":"", // 日期范围
        "line_charts_x":[ // 横坐标值
            "0",
            "1",
            "2"
        ],
        "line_charts_y":[ // 纵坐标值
            100,
            200,
            300
        ]
        "ret_code": 200,
        "ret_msg": "成功",
    }
    "err_code": 200,
    "err_msg": "成功",
}
```
### 3 端口使用数据明细
```
POST  /ota/stat/outlet/query_port_data_list
请求参数:
{
    "model":"", // 型号名称
    "hw_ver":"", // 硬件版本号
    "fw_ver":"", // 固件版本号
    "start_date":"2017/12/18", // 起始日期
    "end_date":"2017/12/20" // 结束日期
}

返回示例：
{
    "result": {
        "list":[
            {
                "date":"",// 日期
                "port_count":0,// 端口使用数量
                "device_count":0,// 设备数量
                "device_percent":"10%",// 设备数占比
            }
        ],
        "ret_code": 200,
        "ret_msg": "成功",
    }
    "err_code": 200,
    "err_msg": "成功",
}
```
### 4 端口使用数据明细导出
```

GET  /ota/stat/outlet/query_port_data_list_export
请求参数:
{
    "model":"", // 型号名称
    "hw_ver":"", // 硬件版本号
    "fw_ver":"", // 固件版本号
    "start_date":"2017/12/18", // 起始日期
    "end_date":"2017/12/20" // 结束日期
}

返回示例
response:
{
    "err_code": 0,
    "err_msg": "请求成功"
}
```

## 2. 电量数据
###  1 查询电量分布所需信息
```

 POST /ota/stat/outlet/query_elct_data_need_info
 请求参数：
 {
     "model":"-1",// 型号，-1代表"全部"
     "hardware_version":"-1",// 硬件版本号，-1代表"全部"
 }

返回示例:
{
    "result": {
        "models": [ // 型号名称和ID
            {
            "str_id":"",
            "str_val":""
            }
        ],
        "hw_vers": [ // 硬件版本号和ID
            {
            "str_id": "",
            "str_val": ""
            }
        ],
        "fw_vers": [ // 固件版本号和ID
            {
            "str_id": "",
            "str_val": ""
            }
        ],
        "ret_code": 200,
        "ret_msg": "成功",
    },
    "err_code": 200,
    "err_msg": "成功",
}
```
### 2 查询电量使用分布（日、周、月 通用接口）
```

POST  /ota/stat/outlet/query_elct_data
请求参数:
{
    "model":"", // 型号名称
    "hw_ver":"", // 硬件版本号
    "fw_ver":"", // 固件版本号
    "date":"2017/12/18", // 日期（具体到年月日，服务器自动判断对应日周月时间范围）
    "time_veidoo":1 // 时间维度 1.日 2.周 3.月
}

返回示例：
{
    "result": {
        "line_charts_x":[ // 横坐标值
            "0~3度",
            "3~6度",
            "6~9度"
        ],
        "line_charts_y":[ // 纵坐标值
            100,
            200,
            300
        ]
        "ret_code": 200,
        "ret_msg": "成功",
    }
    "err_code": 200,
    "err_msg": "成功",
}
```
### 3 电量使用数据明细（日、周、月 通用接口）
```

POST  /ota/stat/outlet/query_elct_data_list
请求参数:
{
    "model":"", // 型号名称
    "hw_ver":"", // 硬件版本号
    "fw_ver":"", // 固件版本号
    "date":"2017/12/18", // 日期（具体到年月日，服务器自动判断对应日周月时间范围）
    "time_veidoo":1 // 时间维度 1.日 2.周 3.月
}

返回示例：
{
    "result": {
        "list":[
            {
                "date":"",// 日期
                "elct_count":0,// 电量使用数量
                "device_count":0,// 设备数量
                "device_percent":"10%",// 设备数占比
            }
        ],
        "ret_code": 200,
        "ret_msg": "成功",
    }
    "err_code": 200,
    "err_msg": "成功",
}
```
### 4 电量使用数据明细导出（日、周、月 通用接口）
```

GET  /ota/stat/outlet/query_elct_data_list_export
请求参数:
{
    "model":"", // 型号名称
    "hw_ver":"", // 硬件版本号
    "fw_ver":"", // 固件版本号
    "date":"2017/12/18", // 日期（具体到年月日，服务器自动判断对应日周月时间范围）
    "time_veidoo":1 // 时间维度 1.日 2.周 3.月
}

返回示例
"result": {
        "ret_code": 200,
        "ret_msg": "成功",
    }
    "err_code": 200,
    "err_msg": "成功",
```

## 3.固件升级
### 3.1固件统计分析下拉框数据
```

POST  /ota/stat/ota_upgrade/upgrade_data/query_drop_info
请求参数：
{
    "product_area_id":""", // 产品名称
    "product_line_id":"TC1", //型号
    "hw_ver":"R1",  // 硬件版本
    "new_ver":"1.0.0.1", // 新版本号   
}
响应参数：
{
    "result": {
        "areas":[ // 产品名称id跟val
            {
                "str_id":"100",
				"str_val":""
            },
            {
                "str_id":"100",
				"str_val":""
            }
        ],
		"lines":[ // 型号id跟val
            {
                "str_id":"100",
				"str_val":""
            },
            {
                "str_id":"100",
				"str_val":""
            }
        ],
		"hw_vers":[ // 硬件版本号id跟val
            {
                "str_id":"100",
				"str_val":""
            },
            {
                "str_id":"100",
				"str_val":""
            }
        ],
		"new_vers":[ // 新版本id跟val
            {
                "str_id":"100",
				"str_val":""
            },
            {
                "str_id":"100",
				"str_val":""
            }
        ],
		"support_vers":[ // 支持版本id跟val
            {
                "str_id":"100",
				"str_val":""
            },
            {
                "str_id":"100",
				"str_val":""
            }
        ]
        "ret_code": 200,
        "ret_msg": "成功",
    }
    "err_code": 200,
    "err_msg": "成功",
}
```

### 3.2固件统计分析升级相关信息
```
POST  /ota/stat/ota_upgrade/upgrade_data/get_stat_info/{cur_page}/{page_size}
请求参数：
{
    "product_area_id":""", // 产品名称
    "product_line_id":"TC1", //型号
    "hw_ver":"R1",  // 硬件版本
    "new_ver":"1.0.0.1", // 新版本号
	"sup_ver":"", // 支持版本
	"start_time":"2017/12/30 12:23:00", // 开始时间
	"end_time":"2017/12/30 12:23:00" //结束时间
}
响应参数：
{
    "result": {
        "ota_upgrade_datas":[
            {
                "update_time":"2017/01/02 12:30:00" //更新日期
                "create_time":"2017/01/02 12:30:00", // 创建日期
                "product_area_id":"", // 产品名称id
                "product_area_name":"",  // 产品名称
                "product_line_id":"", // 型号Id
                "product_line_name":"", // 型号名称
                "hw_ver":"", // 硬件版本
                "new_ver":"", // 新版本
                "support_ver":"", // 支持版本
                "upgrade_type":"", // 升级方式
                "total_dev_amonut":"300", // 总设备数量
                "notice_dev_amonut":"50", // 通知设备数量
                "updt_success_amount":"100", // 升级成功数量
                "updt_success_rate":"10%" // 升级成功率 = 升级成功数量/通知设备数量
            },
            {
                "create_time":"2017/01/02 12:30:00", // 日期
                "product_area_id":"", // 产品名称id
                "product_area_name":"",  // 产品名称
                "product_line_id":"", // 型号Id
                "product_line_name":"", // 型号名称
                "hw_ver":"", // 硬件版本
                "new_ver":"", // 新版本
                "support_ver":"", // 支持版本
                "upgrade_type":"", // 升级方式
                "total_dev_amonut":"300", // 总设备数量
                "notice_dev_amonut":"50", // 通知设备数量
                "updt_success_amount":"100", // 升级成功数量
                "updt_success_rate":"10%" // 升级成功率 = 升级成功数量/通知设备数量
            }
        ],
        "ret_code": 200,
        "ret_msg": "成功",
    }
    "err_code": 200,
    "err_msg": "成功",
}
```

二、设备管理
============

## 1.设备列表

### （1）获取设备所有类型信息：
```
POST /ota/devicemgr/device_list/query_device_all_type
请求参数：
{
    "product_area_id":-1,// 产品ID，-1代表"全部"
    "product_line_id":-1,// 型号ID，-1代表"全部"
    "hwver_id":"-1"// 硬件版本号，-1代表"全部"
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功",
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
        "part_numbers":[
            {
                "part_number":"-1"料号id,
                "part_number_val":"全部"  料号
            },
            {
                "part_number":"45646546"料号id,
                "part_number_val":"45646546"料号
            },
            {
                "part_number":"45646546"料号id,
                "part_number_val":"45646546"料号
            }
        ],
        "areas": [ //产品名称和id
            {
                "product_area_id":-1 //产品id
                "product_area_name": "全部", //产品名称
            }，
            {
                "product_area_id":1000 //产品id
                "product_area_name":"outlet", // 产品名称
            }
            {
                "product_area_id":2000
                "product_area_name":"outlet2",
            }
        ],
        "lines": [ //型号名称和id
            {
                "product_line_id":-1
                "product_line_name": "全部",
            }，
            {
                "product_line_id": 1000,
                "product_line_name":"T1"
            },
            {
                "product_line_id": 2000,
                "product_line_name":"T1"
            }
        ],
        "hwvers": [ //硬件版本和id
            {
                "hwver_id": "-1",
                "hwver_val":"全部"
            },
            {
                "hwver_id": "V1",
                "hwver_val":"V1"
            },
            {
                "hwver_id": "V1",
                "hwver_val":"V1"
            }
        ]
    }
}
```
### (2)查询设备列表
```
Post /ota/devicemgr/device_list/query_device_list/{cur_page}/{page_size} //page_size每页大小，cur_page当前页码
请求参数：
{
    "product_area_id":1000, // 产品名称,
    "part_number":"xxxx"料号id
    "product_line_id":2000, // 型号,
    "hwver":"12220" // 硬件版本,
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功",
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
        "total_count": 10, //总记录数
        "products": [
            {
                "id":1123, //唯一标示id
                "part_number":"5454DFDFD23423",料号
                "product_area_name":"outlet",// 产品名称
                "product_line_name":"T1", //型号
                "hwver":"1020",// 硬件版本id
                "fwver":"1.0.0.1,1.0.0.2"//支持的版本
                "remarks":"xxxxxx" //备注
            },
            {
                "id":1123, //唯一标示id
               "part_number":"5454DFDFD23423",料号
               "product_area_name":"outlet",// 产品名称
               "product_line_name":"T1", //型号
               "hwver":"1020",// 硬件版本id
               "fwver":"1.0.0.1,1.0.0.2"//支持的版本
               "remarks":"xxxxxx" //备注
            }
        ]
    }
}
```
### (3)添加设备
```
Post /ota/devicemgr/device_list/add_device
请求参数：
{
    "part_number":"5454DFDFD23423", //产品料号
    "product_area_name":"outlet", // 产品名称
    "product_line_name":"T1", // 型号
    "hwver":"V1", // 硬件版本
    "remarks":"xxxxxx" //备注
    "lastOptUid":4565, //操作人uid
    "real_name":"张三"  //操作人姓名
}
响应参数：
{
    "result": {  
        "ret_code": 200,
        "ret_msg": "成功",
    },
    "err_code": 200,
    "err_msg": "成功"
}
```
### (4)编辑设备
```
Post /ota/devicemgr/device_list/edit_device

请求参数：
{
    "id":1123, //唯一标示id
    "part_number":"5454DFDFD23423", //产品料号
    "product_area_name":"outlet", // 产品名称
    "product_line_name":"T1", // 型号
    "hwver":"V1" // 硬件版本
    "remarks":"xxxxxx", //备注
    "lastOptUid":4565, //操作人uid
    "real_name":"张三"  //操作人姓名
}
响应参数:
{
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
    },
    "err_code": 200,
    "err_msg": "成功"
}
```
### (5)删除设备
```
Post /ota/devicemgr/device_list/delete_device
{
    "id":121112, //料号
    "lastOptUid":4565, //操作人uid
    "real_name":"张三"  //操作人姓名
}
响应参数:
{
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
    },
    "err_code": 200,
    "err_msg": "成功"
}
```
2.设备详情
----------

### (1)获取所有设备的类型
```
POST /ota/devicemgr/device_details/query_device_all_type
请求参数：
{
    "device_type":"-1",// 产品ID，-1代表"全部"
    "model":"-1",// 型号ID，-1代表"全部"
    "hardware_version":"-1"// 硬件版本号，-1代表"全部"
}
响应参数
{
    "err_code": 200,
    "err_msg": "成功",
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
        "device_types": [ //产品名称和id
            {
                "device_type": "-1",
                "device_type_val": "全部"
            },
            {
                "device_type": "outlet",
                "device_type_val": "outlet"
            }
            {
                "device_type": "phihome_echo",
                "device_type_val": "phihome_echo"
            }
        ],
        "models": [ //型号名称和id
            {
                "model": "-1",
                "model_val": "全部"
            }，
            {
                "model": "T1",
                "model_val": "T1"
            },
            {
                "model": "T2",
                "model_val": "T2"
            }
        ],
        "hardware_versions": [ // 硬件版本和id
            {
                "hardware_version": "-1"
                "hardware_version_val": "全部"
            },
            {
                "hardware_version": "V1"
                "hardware_version_val": "V1"
            },
            {
                "hardware_version": "V2"
                "hardware_version_val": "V2"
            }
        ],
        "rom_versions": [ // 固件版本和id
            {
                "rom_version": "-1",
                "rom_version_val": "全部"
            },
            {
                "rom_version": "1.0.0.1",
                "rom_version_val": "1.0.0.1"
            },
            {
                "rom_version": "1.0.0.2",
                "rom_version_val": "1.0.0.2"
            }
        ],
        "areas":[ //地区和id
            {
                "city_id":-1,
                "city_name":"全部"
            },
            {
                "city_id":1,
                "city_name":"北京"
            },
            {
                "city_id":20,
                "city_name":"天津"
            }
        ]
    } 
}
```
### (2)搜索设备详情
```
Post /ota/devicemgr/device_details/query_devices__info/{cur_page}/{page_size}

请求参数:
{
    "device_type":"outlet", // 产品名称
    "model":"T1", // 型号(非必选)
    "hardware_version":"V1", // 硬件版本
    "rom_version":"1.0.0.1", // 固件版本号
    "city_id":20,
    "phone_number":"12345648" // 手机号码
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
        "total_count":10,
        "devices_info":[
            {
                "device_type":"outlet", // 产品名称
                "model":"T1", // 型号
                "hardware_version":"V1", // 硬件版本
                "rom_version":"1.0.0.1", // 固件版本号
                "device_id":"sdfsdf3423424", // 设备id
                "mac":"aa:vv:sd:dd:dd:dd:dd", //mac地址
                "city_name":"北京",
                "uid":"", //用户uid
                "phone_number":""， //手机号码
                "online_status":1 //在线状态,1在线，0离线
            },
            {
                "device_type":"outlet", // 产品名称
                "model":"T1", // 型号
                "hardware_version":"V1", // 硬件版本
                "rom_version":"1.0.0.1", // 固件版本号
                "device_id":"sdfsdf3423424", // 设备id
                "mac":"aa:vv:sd:dd:dd:dd:dd", //mac地址
                "city_name":"北京",
                "uid":"", //用户uid
                "phone_number":""， //手机号码
                "online_status":1 //在线状态,1在线，0离线
            }
        ]
    }
}
```
### (3)查询设备在线状态
```
 Post /ota/devicemgr/device_details/query_devices_online_status
 请求参数：
 
 {
     "device_id":"xxxxx", // 设备Id
 }
 响应参数：
 {
     "err_code": 200,
     "err_msg": "成功"
     "result": {
         "ret_code": 200,
         "ret_msg": "成功",
         "online_status":1//在线状态,1在线，0离线
     }
 }
```
3.添加固件(phihome跟音响)
----------

### (1)添加固件搜索下拉框数据
```
Post /ota/query_addfirmware_info
请求参数：
{
	"product_type_id":"1000", // 产品类型id，1000为outlet,1001为phihome
	"line":"10000000", // 型号
	"hw_ver":"", // 硬件版本号
}

响应参数:
{
	"result": {
		"lines": [//型号名称和id
			{
				"str_id": "-1",
				"str_val": "全部"
			},
			{
				"str_id": "1000000",
				"str_val": "T1"
			},
			{
				"str_id": "1000001",
				"str_val": "T2"
			}
		],
		"hw_vers":[ // 硬件版本id跟val
			{
				"str_id": "-1",
				"str_val": "全部"
			},
			{
				"str_id": "T1",
				"str_val": "T1"
			}
		],
		"new_vers":[ // 新版本号跟id
			{
				"str_id": "-1",
				"str_val": "全部"
			},
			{
				"str_id": "1.0.0.0",
				"str_val": "1.0.0.0"
			}
		],
		"upgrade_types":[
			{
				"str_id": "-1",
				"str_val": "全部"
			},
			{
				"str_id": "0",
				"str_val": "静默升级"
			}
		]
		"ret_code": 200,
		"ret_msg": "成功"
	},
	"err_code": 200,
	"err_msg": "成功"
}
```
### (2)添加和编辑（带文件）固件接口
```
Post /ota/add_ver_relation
请求参数：
{
	"id":33, // 添加没有id,编辑有id
    "file":"",//上传固件文件
    "product_area_id":"",//  产品id, 1000为phihome,1001为outlet
    "product_line_id":"",//型号id
    "hw_ver":"",//硬件版本
    "fw_ver":"",//固件版本
    "update_time_str":"",//更新时间
    "content":""//更新内容
    "file_md5":"xxx",// 通过手填，不需要查询
    "support_ver_way":"1",//支持版本方式,1为选择版本，2为版本段
	"support_ver":"1.0.0.0,2.0.0.0" // 支持版本
	"lastOptUid":565, //操作人uid
    "real_name":"张三"  //操作人姓名
}

返回参数:

//以下为返回example
{
	"result": {
		"ret_code": 200,
		"ret_msg": "成功",
		"extend_msg": null
	},
	"err_code": 200,
	"err_msg": "成功"
}
```

### (3)添加和编辑固件接口下拉框数据
```
Post /ota/query_addfirmware_drop_info
请求参数：
{
	"product_type_id":"1000", // 产品类型id，1000为outlet,1001为phihome
	"line":"10000000", // 型号
	"hw_ver":"T1" //硬件版本号
}

响应参数:
{
	"result": {
		"lines": [//型号名称和id
			{
				
				"str_id": "1000000",
				"str_val": "T1"
			}
		],
		"hw_vers":[ // 硬件版本id跟val
			{
				"str_id": "T1",
				"str_val": "T1"
			}
		],
		"support_vers":[
		    {
                "str_id": "-1",
                "str_val": "全部"
            }
			{
				"str_id": "1.0.0.1",
				"str_val": "1.0.0.1"
			}
		],
		"sup_vers_no_all": [
            {
                "str_id": "1.0.0",
                "str_val": "1.0.0"
            }
        ],
		"ret_code": 200,
		"ret_msg": "成功"
	},
	"err_code": 200,
	"err_msg": "成功"
}
```
### (4)更新固件接口(不带文件)
```
Post /ota/update_ver_relation
请求参数：
{
    "id":33, // 编辑有id
    "product_area_id":"",//  产品id, 1000为phihome,1001为outlet
    "product_line_id":"",//型号id
    "hw_ver":"",//硬件版本
    "fw_ver":"",//固件版本
    "update_time_str":"",//更新时间
    "content":""//更新内容
    "support_ver_way":"1",//支持版本方式,1为选择版本，2为版本段
	"support_ver":"1.0.0.0,2.0.0.0" // 支持版本
}

//用户自定义返回，例子
response:
{
    //以下为返回example
    {
        "result": {
            "ret_code": 200,
            "ret_msg": "成功"
        },
        "err_code": 200,
        "err_msg": "成功"
    }
}
```
### (5)查询固件列表接口
```
Post /ota/query_firmware_version_list
请求参数：
{
    "page_size":"",//每页大小
    "cur_page":"",//当前第几页
    "product_area_name":"",// 产品id
    "product_line_name":"",// 型号id
    "hw_ver":"" // 硬件版本
    "fw_ver":"",// 新版本号
}
//用户自定义返回，例子
response:
{
    //以下为返回example
    {
        "result": {
            "totalCount": 10,//总记录数
            "firmwareVersions": [
                {
                    "page_size": 0,
                    "cur_page": 0,
                    "start": 0,
                    "end": 0,
                    "id": 2,
                    "product_family_id": 0,
                    "product_family_name": "feixun",
                    "product_area_id": 1000,
                    "product_area_name": "outlet",
                    "product_line_id": 1000000,
                    "product_line_name": "T1",
                    "hw_ver": "V1",
                    "update_time": 1505466872,
                    "update_time_str": "2017-09-15 17:14:32",
                    "content": "版本1",
                    "fw_ver": "1.0.0.0",
                    "file_url": "http://172.31.34.128:8080/file/ota/firmware/T1V1_V1.0.0.0.ota.bin",
                    "file_name": "T1V1_V1.0.0.0.ota.bin",
                    "file_md5": null,
                    "file_size": 0,
                    "support_ver": "1.0.0.0",
                    "support_ver_way":"1", //1为选择版本，2为版本段
                    "op_time": 1505467042,
                    "op_time_str": "2017-09-15 17:17:22",
                    "operator": "admin",
                    "is_relation":"1", // 关联是1，不关联是2
                    "operator_name": "admin",
                    "target_ver": null
                }
            ],
            "ret_code": 200,
            "ret_msg": "成功",
            "extend_msg": null
        },
        "err_code": 200,
        "err_msg": "成功"
    }
}
```
### (6)删除固件接口
```
Post /ota/delete_ver_relation
请求参数：
{
	"id":"33",
	"product_area_id":"",//  产品id, 1000为phihome,1001为outlet
    "product_line_id":"",//型号id
    "hw_ver":"",//硬件版本
    "fw_ver":"",//固件版本
	"support_ver_way":"1",//支持版本方式,1为选择版本，2为版本段
	"support_ver":"1.0.0.0,2.0.0.0" // 支持版本
}
响应参数：
{
    //以下为返回example
    {
        "result": {
            "ret_code": 200,
            "ret_msg": "成功"
        },
        "err_code": 200,
        "err_msg": "成功"
    }
}
```
4.固件升级(phihome跟音响)
----------
### (1)固件升级搜索下拉框数据（跟添加固件接口1一样）
```
Post /ota/query_addfirmware_info
请求参数：
{
    "product_type_id":"1000", // 产品类型id，1000为outlet,1001为phihome
    "line":"10000000", // 型号
    "hw_ver":"", // 硬件版本号
}
响应参数:
{
    "result": {
        "lines": [//型号名称和id
            {
                "str_id": "-1",
                "str_val": "全部"
            },
            {
                "str_id": "1000000",
                "str_val": "T1"
            },
            {
                "str_id": "1000001",
                "str_val": "T2"
            }
        ],
        "hw_vers":[ // 硬件版本id跟val
            {
                "str_id": "-1",
                "str_val": "全部"
            },
            {
                "str_id": "T1",
                "str_val": "T1"
            }
        ],
        "new_vers":[ // 新版本号跟id
            {
                "str_id": "-1",
                "str_val": "全部"
            },
            {
                "str_id": "1.0.0.0",
                "str_val": "1.0.0.0"
            }
        ],
        "upgrade_types":[
            {
                "str_id": "-1",
                "str_val": "全部"
            },
            {
                "str_id": "0",
                "str_val": "静默升级"
            }
        ]
        "ret_code": 200,
        "ret_msg": "成功"
    },
    "err_code": 200,
    "err_msg": "成功"
}
```
### (2)添加固件升级下拉框数据
```
Post /ota/query_upgrade_firmware_info
请求参数：
{
	"product_type_id":"1000", // 产品类型id，1000为outlet,1001为phihome
	"line":"10000000", // 型号
	"hw_ver":"", // 硬件版本号
}
response:
{
    //以下为返回example
    {
        "result": {
            "lines": [//型号名称和id
                {
                    "str_id": "1000000",
                    "str_val": "T1"
                },
                {
                    "str_id": "1000001",
                    "str_val": "T2"
                }
            ],
            "hardWareVers": [
                {
                    "str_id": "V1",
                    "str_val": "V1"
                }
            ],
            "newVers": [
                {
                    "str_id": "1.0.0.0",
                    "str_val": "1.0.0.0"
                }
            ],
			"upgrade_types":[
				{
					"str_id": "-1",
					"str_val": "全部"
				},
				{
					"str_id": "0",
					"str_val": "静默升级"
				}
			],
            "supVers": [
                {
                    "str_id": "-1",
                    "str_val": "全部"
                }
            ],
            "supVersNoAll": [
                {
                    "str_id": "1.0.0",
                    "str_val": "1.0.0"
                }
            ],
            "citys": [
                {
                    "city_id": -1,
                    "city_name": "全部"
                }
            ],
            "macTypes": [
                {
                    "str_id": "-1",
                    "str_val": "全部"
                },
                {
                    "str_id": "1",
                    "str_val": "输入MAC地址"
                },
                {
                    "str_id": "2",
                    "str_val": "MAC地址段"
                },
                {
                    "str_id": "3",
                    "str_val": "导入Excel表格"
                }
                "ret_code": 200,
                "ret_msg": "成功",
                "extend_msg": null
            ],
        "err_code": 200,
        "err_msg": "成功"
    }
}
```
### (3)添加跟编辑固件升级接口
```
Post /ota/add_upgrade_policy
请求参数：
{
	"id":33,  // 编辑操作需要添加id
    "product_area_id":"", //产品id
    "product_line_id":"", //型号id
    "hw_ver":"", //固件版本
    "fw_ver":"", //硬件版本
    "update_type":"3,5",//升级方式
	"start_updt_time":"02:00" // 升级开始时间
	"end_updt_time":"23:00" // 升级结束时间
	"support_ver_way":"1", //支持版本方式,1为选择版本，2为版本段
    "support_ver":"1.0.0.1,1.0.0.2", //支持版本
    "citys":"", //地区
    "gray_target":"", //设备数量
    "active_status":"1", //是否激活，默认值为1，0为关闭，1为开启
    "white_list":"",//用户id
    "mac_addr_list":"",// MAC地址值
    "mac_type":"",// MAC地址类型
    "lastOptUid":565, //操作人uid
    "real_name":"张三"  //操作人姓名
}

//用户自定义返回，例子
response:
{
    //以下为返回example
    {
        "result": {
            "ret_code": 200,
            "ret_msg": "成功",
            "extend_msg": null
        },
        "err_code": 200,
        "err_msg": "成功"
    }
}
```
```
Post /ota/add_excel_upgrade_policy
请求参数：
{
	"id":33,  // 编辑操作需要添加id
    "file":"", // 多表格文件上传
    "product_area_id":"", //产品id
    "product_line_id":"", //型号id
    "hw_ver":"", //固件版本
    "fw_ver":"", //硬件版本
    "update_type":"3,5",//升级方式
	"start_updt_time":"02:00" // 升级开始时间
	"end_updt_time":"23:00" // 升级结束时间
	"support_ver_way":"1", //支持版本方式,1为选择版本，2为版本段
    "support_ver":"1.0.0.1,1.0.0.2", //支持版本
    "citys":"", //地区
    "gray_target":"", //设备数量
    "active_status":"1", //是否激活，默认值为1，0为关闭，1为开启
    "white_list":"",//用户id
    "mac_addr_list":"",// MAC地址值
    "mac_type":"",// MAC地址类型为
    "lastOptUid":565, //操作人uid
    "real_name":"张三"  //操作人姓名
}

//用户自定义返回，例子
response:
{
    //以下为返回example
    {
        "result": {
            "ret_code": 200,
            "ret_msg": "成功",
            "extend_msg": null
        },
        "err_code": 200,
        "err_msg": "成功"
    }
}
```

### (4)查询固件升级列表接口
```
Post /ota/query_upgrade_policy_list
请求参数：
{
    "page_size":"",//每页大小
    "cur_page":"",//当前第几页
    "product_area_name":"",//搜索条件（非必须）：产品名称
    "product_line_name":"",//搜索条件（非必须）：型号
    "hw_ver":"", // 硬件版本
    "fw_ver":"",//搜索条件（非必须）：新版本号
    "update_type":"",//搜索条件（非必须）：升级方式
}
//用户自定义返回，例子
response:
{
    //以下为返回example
    {
        "result": {
            "totalCount": 10,//总记录数
            "upgradePolicys": [
                {
                    "files":[
                        {
                            "file_name":"file1", // 文件名称 
                            "type":1  // 文件对应的类型
                        },
                        {
                            "file_name":"file1", // 文件名称 
                            "type":2  // 文件对应的类型
                        }
                    ]
                    "resCitys": [
                        {
                            "city_id": 376,
                            "city_name": "东莞"
                        },
                        {
                            "city_id": 379,
                            "city_name": "揭阳"
                        }
                    ],
                    "page_size": 0,
                    "cur_page": 0,
                    "start": 0,
                    "end": 0,
                    "id": 2,
                    "product_family_id": 0,
                    "product_family_name": "feixun",
                    "product_area_id": 1000,
                    "product_area_name": "outlet",
                    "product_line_id": 1000000,
                    "product_line_name": "T1",
                    "hw_ver": "V1",
                    "fw_ver": "1.0.0.0",
                    "update_type": "5,2",
                    "is_silent": 0,
                    "support_type":"2" // 支持版本添加类型，1为点添加，2为段添加
                    "support_ver": "1.0.0.1,1.0.0.2",
                    "show_support_ver": "1.0.0.1-1.0.0.2",
                    "citys": "376,379",
                    "gray_target": 5000,
                    "gray_quantity": 0,
                    "white_list": "1084,",
                    "show_white_list": "1084,",
                    "mac_addr_list": "-1",
                    "show_mac_addr_list": "全部",
                    "mac_type": 1,
                    "active_status": 0,
                    "show_active_status": "反激活",
                    "support_ver_way":"1", //1为选择版本，2为版本段
                    "op_time": 1505888317,
                    "op_time_str": "2017-09-20 14:18:37",
                    "operator": "admin",
                    "is_update": null,
                    "start_updt_time":"02:00" // 升级开始时间
                    "end_updt_time":"23:00" // 升级结束时间
                }
            ],
            "ret_code": 200,
            "ret_msg": "成功"
        },
        "err_code": 200,
        "err_msg": "成功"
    }
}
```
### (5)通过删除表格删除对应的MAC
```
Post /ota/upgrade_policy/delete_mac
请求参数：
{
    "id":22, 
    "type":"1,2,3", // 表格对应的类型,如果不是表格删除，这个可选
    "mac_list":"dd:22:dd:333,dd:22:dd:333", // 多个mac地址,通过","分隔，可选
    "lastOptUid":565, //操作人uid
    "real_name":"张三"  //操作人姓名
}
//用户自定义返回，例子
response:
{
    //以下为返回example
    {
        "result": {
            "ret_code": 200,
            "ret_msg": "成功"
        },
        "err_code": 200,
        "err_msg": "成功"
    }
}
```
### (6)分页查询mac
```
Post /ota/upgrade_policy/get_mac_list/{cur_page}/{page_size}
请求参数：
{
    "id":22， // 记录id
    "mac":"xxxx" // 需要查询的mac
}
//用户自定义返回，例子
response:
{
    //以下为返回example
    {
        "result": {
            "ret_code": 200,
            "ret_msg": "成功",
            "total_count":"10"
            "mac_list":[
                {
                    "mac":"XXXX"
                }，
                {
                    "mac":"XXXX"
                }
            ]
        },
        "err_code": 200,
        "err_msg": "成功"
    }
}
```
## 5.升级详情(phihome跟音响)
### (1)获取型号、硬件版本号、新版本、支持版本、升级方式
```
 Post /ota/devicemgr/updt_detail/query_all_type
 请求参数：
{
    "new_ver":"1.0.0.1", // 新版本号
    "hw_ver":"R1",  // 硬件版本
    "product_line_id":"TC1", //型号
    "product_type_id":1000, // 产品类型，1000为phihome产品，1001为斐讯ai产品
 }
 
 //用户自定义返回，例子
 response:
 {
     //以下为返回example
     {
         "result": {
            "lines": [//型号名称和id
                  {
                      "str_id": "1000000",
                      "str_val": "T1"
                  },
                  {
                      "str_id": "1000001",
                      "str_val": "T2"
                  }
             ],
             "hw_vers": [  //硬件id和val
                 {
                     "str_id": "R1",
                     "str_val": "R1"
                 }
                 {
                     "str_id": "TC1",
                     "str_val": "TC1"
                 }
             ],
             "new_vers":[ // 新版本号id跟val
                {
                    "str_id":"1.0.0.1",
                    "str_val":"1.0.0.1"
                },
                {
                    "str_id":"1.0.0.1",
                    "str_val":"1.0.0.1"
                }
             ],
             "support_vers":[
                {
                    "str_id":"1.0.0.1",
                    "str_val":"1.0.0.1"
                },
             ]
             "upgrade_types":[ //升级方式和id
                 {
                     "str_id":"1", // 升级id
                     "str_val":"强制升级"
                 },
                 {
                     "str_id":"2",
                     "str_val":"半强制升级"
                 },
                 {
                     "str_id":"3",
                     "str_val":"普通升级"
                 }
             ]
             "upgrade_status":[
                {
                     "str_id":"1",
                     "str_val":"成功"
                 }，
                 {
                      "str_id":"1",
                      "str_val":"失败"
                  }     
             ]
             "ret_code": 200,
             "ret_msg": "成功",
             "extend_msg": null
         },
         "err_code": 200,
         "err_msg": "成功"
     }
 }
```
### (2)查询升级详情信息
```
Post /ota/devicemgr/updt_detail/query_updt_info/{cur_page}/{page_size}
请求参数：
{
    "product_line_id":"1000000", //型号
    "hw_ver":"R1",  // 硬件版本
    "new_ver":"1.0.0.1", // 新版本号
    "sup_ver":"1.0.0.1",  // 支持版本
    "upgrade_type_id":"2", // 升级方式id
    "mac":"sd:sd:er:d3:99:dd", // mac地址
    "upgrade_status":"", // 升级状态
    "start_time":"2017/10/20 12:30:00", // 开始时间
    "end_time":"2017/10/20 12:30:00", // 结束时间
    "product_type_id":1000, // 产品类型，1000为phihome产品，1001为斐讯ai产品
}
响应参数：
 {
     //以下为返回example
     {
         "result": {
            "updt_detail_info": [//型号名称和id
                  {
                      "update_time":"2017/10/20 12:30:00" // 更新时间，对应需求里的日期
                      "create_time":"2017/10/20 12:30:00", // 创建时间
                      "product_line_name":"TC1",
                      "hw_ver":"R1", // 硬件版本
                      "new_ver":"1.0.0.1", // 新版本
                      "support_ver":"1.0.0.0", // 支持版本
                      "upgrade_type_id":"2", // 升级方式id
                      "upgrade_type_name":"强制升级" // 升级方式名称
                      "device_id":"SD:DD:WW:RS:KS:KK", // 设备id
                      "mac":"", // mac地址
                      "area":"深圳", // 地区
                      "uid":"2312315", // 用户id
                      "phone_no":"" // 手机号码
                      "upgrade_status":"2" // 升级状态
                  },
                  {
                        "create_time":"2017/10/20 12:30:00",
                        "product_line_name":"TC1",
                        "hw_ver":"R1", // 硬件版本
                        "new_ver":"1.0.0.1", // 新版本
                        "support_ver":"1.0.0.0", // 支持版本
                        "upgrade_type_id":"2", // 升级方式id
                        "upgrade_type_name":"强制升级" // 升级方式名称
                        "device_id":"SD:DD:WW:RS:KS:KK", // 设备id
                        "mac":"", // mac地址
                        "area":"深圳", // 地区
                        "uid":"2312315", // 用户id
                        "phone_no":"" // 手机号码
                        "upgrade_status":"2" // 升级状态
                  }
             ]
             "ret_code": 200,
             "ret_msg": "成功",
             "extend_msg": null
         },
         "err_code": 200,
         "err_msg": "成功"
     }
 }
```



三、APP管理模块接口
===================

## 1. PhiHome和斐讯AI（公共接口）

### 升级管理页面

### (1)获取所有的平台、新版本号（支持版本也是这个）、升级方式（搜索下拉框）
```
Post /ota/appmgr/version/query_all_type
请求参数：
{
    "ostype_id":"1000",
    "version":"1.0.0",
    "product_type_id":1000, // 产品类型，1000为phihome产品，1001为斐讯ai产品
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
        "ostypes":[ // 平台
            {
                "str_id":"-1",
                "str_val":"全部",
            },
            {
                "str_id":"1001", // 平台类型id ,1001为IOS,1002为android
                "str_val":"android",
            },
            {
                "str_id":"1002",
                "str_val":"IOS",
            }
        ],
        "versions":[ 版本号和id
            {
                "str_id":"-1",
                "str_val":"全部"
            },
            {
                "str_id":"1.0.0.1",
                "str_val":"1.0.0.1"
            },
            {
                "str_id":"1.0.0.1",
                "str_val":"1.0.0.1"
            }
        ],
        "upgrade_types":[ //升级方式和id
            {
                "str_id":"1", // 升级id
                "str_val":"强制升级"
            },
            {
                "str_id":"2",
                "str_val":"半强制升级"
            },
            {
                "str_id":"3",
                "str_val":"普通升级"
            }
        ]
    }
}
```

### (2)获取所有的平台、新版本号（支持版本也是这个）、升级方式（添加跟编辑下拉框）
```
Post /ota/appmgr/version/query_type_for_add_edit
请求参数：
{
    "product_type_id":1000, // 产品类型，1000为phihome产品，1001为斐讯ai产品
    "ostype_id":"1000"// 平台Id,1000为IOS,1001为Android
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
        "ostypes":[ // 平台
            {
                "str_id":"1001", // 平台类型id ,1001为IOS,1002为android
                "str_val":"android",
            },
            {
                "str_id":"1002",
                "str_val":"IOS",
            }
        ],
        "versions":[ 版本号和id
            {
                "str_id":"1.0.0.1",
                "str_val":"1.0.0.1"
            },
            {
                "str_id":"1.0.0.1",
                "str_val":"1.0.0.1"
            }
        ],
        "upgrade_types":[ //升级方式和id
            {
                "str_id":"1", // 升级id
                "str_val":"强制升级"
            },
            {
                "str_id":"2",
                "str_val":"半强制升级"
            },
            {
                "str_id":"3",
                "str_val":"普通升级"
            }
        ],
        "sup_vers":[ //支持版本id及其val
            {
                "str_id":"全部版本", // 升级id
                "str_val":"全部版本"
            },            
        ]
    }
}
```

### (3)查询升级策略
```
Post /ota/appmgr/version/query_upgrade_info/{cur_page}/{page_size}

请求参数：
{
    "ostype":"1001", // 平台类型id ,1001为IOS,1002为android
    "version":"1.0.0.1", //版本号
    "product_type_id":1000, // 产品类型，1000为phihome产品，1001为斐讯ai产品
    "upgrade_type_id":"3" //升级方式id
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
        "total_count":"10"
        "upgrade_policys":[
            {
                "id":1,
                "ostype":"1001", // 平台类型id ,1001为IOS,1002为android
                "ostype_name":"IOS", // 平台名字 ,IOS或者为android
                "version":"1.0.0.1", //版本
                "upgrade_type_id":"1",
                "upgrade_type_name":"强制升级",
                "old_version":"1.0.0.0", //支持版本
                "note":"备注",
                "update_time":"2017/12/23 23:11:26", //更新时间
            },
            {
                "id":2,
                "ostype":"1001", // 平台类型id ,1001为IOS,1002为android
                "ostype_name":"IOS", // 平台名字 ,IOS或者为android
                "version":"1.0.0.1", //版本
                "upgrade_type_id":"1",
                "upgrade_type_name":"强制升级",
                "old_version":"1.0.0.0", //支持版本
                "note":"备注",
                "update_time":"2017/12/23 23:11:26", //更新时间
            }
        ]
    }
}
```
### (4)添加版本(下拉框的数据调用（2）的接口获取)
```
Post /ota/appmgr/version/add_upgrade_info

请求参数：
{
    "ostype":"1001", // 平台id
    "new_version":"1.0.0.1", //版本号
    "upgrade_type_id":3, //升级方式id
    "old_version":"全部版本", //支持版本号，支持全部版本
    "note":"xxxx", //备注
    "product_type_id":1000, // 产品类型，1000为phihome产品，1001为斐讯ai产品
    "lastOptUid":565, //操作人uid
    "real_name":"张三"  //操作人姓名
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功"
    }
}
```
### (5)编辑版本
```
Post /ota/appmgr/version/edit_upgrade_info

请求参数：
{
    "id":"11" //序号id
    "ostype":"1000", // 平台id
    "new_version":"1.0.0.1", //版本号
    "upgrade_type_id":3, //升级方式id
    "old_version":"全部版本", //支持版本号，默认全部版本
    "note":"xxxx", //备注
    "product_type_id":1000, // 产品类型，1000为phihome产品，1001为斐讯ai产品
    "lastOptUid":4565, //操作人uid
    "real_name":"张三"  //操作人姓名
}

响应参数：

{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功"
    }
}
```
### 渠道安装包页面

### (1)获取所有平台、渠道名、渠道名称、版本号
```
Post /ota/appmgr/channel_package/query_all_type
请求参数：
{
    "ostype_id":"1000",
    "channel_id":"11",
    "product_type_id":1000 // 产品类型，1000为phihome产品，1001为斐讯ai产品
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
        "ostypes":[ // 平台
             {
                 "str_id":"-1", // 平台类型id ,1000为IOS,1001为android
                 "str_val":"全部",
             },
            {
                "str_id":"1000", // 平台类型id ,1000为IOS,1001为android
                "str_val":"IOS",
            },
            {
                "str_id":"1001",
                "str_val":"android",
            }
        ],
        "channel_numbers":[ // 渠道id跟渠道号
            {
                "str_id":"-1", //渠道id
                "str_val":"全部",
            },
            {
                "str_id":"11", // 渠道id
                "str_val":"qaqa",
            },
            {
                "str_id":"12", // 渠道id
                "str_val":"qaqa",
            },
            ],
        "channel_names":[ // 渠道id跟渠道名称
            {
                "str_id":"-1", // 渠道id
                "str_val":"全部",
            },
            {
                "str_id":"32",  // 渠道id
                "str_val":"android",
            },
            {
                "str_id":"555",  // 渠道id
                "str_val":"android",
            }
            ],
            "versions":[ // 版本id跟版本号
            {
                "str_id":"-1", 
                "str_val":"全部",
            },
            {
                "str_id":"1.0.0.0",
                "str_val":"1.0.0.0"
            },
            {
                "str_id":"1.0.0.0",
                "str_val":"1.0.0.0"
            },
            {
                "str_id":"1.0.0.0",
                "str_val":"1.0.0.0"
            }
        ]
    }
}
```
### (2)获取渠道安装包信息
```
Post /ota/appmgr/channel_package/query_channel_package_info/{cur_page}/{page_size}
请求参数：
{
    "ostype_id":"1000", // 平台id，1000为IOS,1001为android
    "channel_number":"11", //渠道id
    "channel_name":"12", // 渠道id
    "version":"1.0.0.1", //版本号
    "product_type_id":1000, // 产品类型，1000为phihome产品，1001为斐讯ai产品
    "start_time":"2017/12/12 17:55:30",// 开始时间，具体到时分秒
    "end_time":"2017/12/28 17:55:30", // 结束时间，具体到时分秒
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功"
        "total_count":"10"
        "channel_packages":[
            {
                "id":111,
                "ostype_id":"1000", // 平台id, 1000为IOS,1001为android
                "ostype_name":"IOS",// 平台名称
                "channel_id":"11", // 渠道id 
                "channel_number":"qaqa", //渠道号
                "channel_name":"android", //渠道名称
                "version":"1.0.0", //版本号
                "ver_code":3, // code号，用于版本对比
                "qr_code_url":"", // 二维码下载地址
                "file_url":"http://xxxx", // 文件下载地址
                "file_name":"aaaa", // 文件名称
                "update_time":"2017/12/23 23:11:26", //更新时间
                "inter_note":"更新内容(内部)",
                "exter_note":"更新内容(外部)",
                "last_opt_user_name":"张三",// 操作人
                "create_time":"2017/12/23 23:11:26", //操作时间
            },
            {
                "id":122,
                "ostype_id":"1000", // 平台id, 1000为IOS,1001为android
                "ostype_name":"IOS",// 平台名称
                "channel_id":"11", // 渠道id 
                "channel_number":"qaqa", //渠道号
                "channel_name":"android", //渠道名称
                "version":"1.0.0", //版本号
                "ver_code":3, // code号，用于版本对比
                "qr_code_url":"", // 二维码下载地址
                "file_url":"http://xxxx", // 文件下载地址
                "file_name":"aaaa", // 文件名称
                "update_time":"2017/12/23 23:11:26", //更新时间
                "inter_note":"更新内容(内部)",
                "exter_note":"更新内容(外部)",
                "last_opt_user_name":"张三",// 操作人
                "create_time":"2017/12/23 23:11:26", //操作时间
            }
        ]
    }
}

```
### (3)添加安装包
```
Post /ota/appmgr/channel_package/add_channel_package
请求参数：
{
    "ostype_id":"1000", // 平台id,ios为1000，android为1001
    "channel_id":"22", // 渠道id
    "version":"1.0.0", // 版本号
    "ver_code":3, // code号，用于版本对比
    "update_time":"2017/12/23 23:11:26", //更新时间
    "inter_note":"更新内容(内部)",
    "exter_note":"更新内容(外部)",
    "file":"xxxx", //APP安装包
    "product_type_id":1000, // 产品类型，1000为phihome产品，1001为斐讯ai产品
    "lastOptUid":4565, //操作人uid
    "real_name":"张三"  //操作人姓名
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功"
    }
}
```

### (4)编辑安装包（文件更改）
```
Post /ota/appmgr/channel_package/edit_channel_package

请求参数：
{
    "id":111,
    "ostype_id":"1000", // 平台id,ios为1000，android为1001
    "channel_id":"11", // 渠道id
    "version":"1.0.0", 版本号
    "ver_code":3, // code号，用于版本对比
    "update_time":"2017/12/23 23:11:26", //更新时间
    "inter_note":"更新内容(内部)",
    "exter_note":"更新内容(外部)",
    "file":"xxxx", //APP安装包
    "product_type_id":1000, // 产品类型，1000为phihome产品，1001为斐讯ai产品
    "lastOptUid":4565, //操作人uid
    "real_name":"张三"  //操作人姓名
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功"
    }
}
```
### (5)渠道和平台下拉框数据调取接口
```
Post /ota/appmgr/channel_package/query_all_channel_ostype
请求参数
{
    "ostype_id":"1001", // 平台id，android的为1001，IOS的为1000
}
响应参数
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
        "ostypes":[ // 平台
            {
                "str_id":"1000", // 平台类型id ,1000为IOS,1001为android
                "str_val":"android",
            },
            {
                "str_id":1001,
                "str_val":"IOS",
            }
         ],
        "channels":[
            {
                "str_id":"11", //渠道id
                "str_val":"百度平台" //渠道号
            },
            {
                "str_id":"22", //渠道id
                "str_val":"App Store" //渠道号
            },
            {
                "str_id":"33", //渠道id
                "str_val":"京东" //渠道号
            },
        ]
    }
}

```
### (6)编辑安装包（文件没有更改）
```
Post /ota/appmgr/channel_package/edit_channel_no_package
请求参数：
{
    "id":111,
    "ostype_id":"1000", // 平台id,ios为1000，android为1001
    "channel_id":"12", // 渠道id
    "version":"1.0.0", 版本号
    "ver_code":3, // code号，用于版本对比
    "update_time":"2017/12/23 23:11:26", //更新时间
    "inter_note":"更新内容(内部)",
    "exter_note":"更新内容(外部)",
    "product_type_id":1000, // 产品类型，1000为phihome产品，1001为斐讯ai产品
    "lastOptUid":4565, //操作人uid
    "real_name":"张三"  //操作人姓名
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,        
        "ret_msg": "成功"
    }
}
```


## 2.首页banner

### (1)添加和编辑有上传图片
```
Post /ota/appmgr/feixun_ai/banner/upload_picture
请求参数：
{
    "id":121 // 记录id，只在编辑有上传图片的时候用
    "file":"XXXX",// 文件，banner图片
    "start_time":"2017/12/12 19:23",// 开始时间 
    "end_time":"2017/12/18 19:23", // 结束时间
    "skip_type_id":1,// 跳转类型，1为H5链接，2为APP动态页面,3为APP页面，
    "title":"你好" // 标题
    "skip_img_name":"图片名称.jpg", // 跳转页图片名称 
    "skip_content":"XXX", // H5的跳转页链接跟动态页面链接地址
    "lastOptUid":4565, // 操作人uid
    "real_name":"张三"  // 操作人姓名
}

响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
    }
}
```

### (2)传第二张跳转页图片(添加接口先调这个再调原始接口)
```
Post /ota/appmgr/feixun_ai/banner/upload_original_picture
请求参数:
{
    "img_width":111, // 需求要求的长跟宽,可选
    "img_height":1111， // 需求要求的长跟宽，可选
    "file":"xxxx" //  文件,跳转页图片
}

响应参数:
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功"
        "img":"http://xxxx" // 图片地址
    }
}
```

### (3)查询所有图片
```
Post /ota/appmgr/feixun_ai/banner/query_all_picture/{cur_page}/{page_size}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
        "total_count":10,
        "pictures":[
            {
                "id":1212,
                "start_time":"2017/12/18 9:00", //开始时间
                "end_time":"2017/12/20 9:00", //结束时间
                "img_url":"http://xxxxx", // banner图片地址
                "banner_img_name":"",  // banner页的文件名
                "skip_img_name":"",  // 跳转页的文件名
                "original_img_url":"", // 原生图片地址
                "title":"title", // 标题
                "skip_type_id":1, // 跳转类型id
                "skip_content":"http//xxxxx", // 跳转内容 
                "last_opt_user_name":"张三",//操作人
                "oper_time":"" //操作时间
            },
            {
                "id":1212,
                "start_time":"2017/12/18 9:00", //开始时间
                "end_time":"2017/12/20 9:00", //结束时间
                "img_url":"http://xxxxx", //图片地址
                "banner_img_name":"",  // banner页的文件名
                "skip_img_name":"",  // 跳转页的文件名
                "original_img_url":"", // 原生图片地址
                "skip_type_id":1, // 跳转类型id
                "title":"title", // 标题
                "skip_content":"http//xxxxx", // 跳转内容
                "last_opt_user_name":"张三",//操作人
                "oper_time":"" //操作时间
            }
        ]
    }
}
```
### (4)编辑图片(不上传banner图片)
```
Post /ota/appmgr/feixun_ai/banner/edit_picture
请求参数
{
    "id":1212,
    "start_time":"2017/12/13 9:00", //开始时间
    "end_time":"2018/12/13 9:00" //结束时间
    "lastOptUid":45465, //操作人uid
    "real_name":"张三"  //操作人姓名
    "skip_type_id":1,// 跳转类型，1为H5链接，2为APP动态页面,3为APP页面，
    "title":"你好" // 标题
    "skip_img_name":"",  // 跳转页的文件名
    "skip_content":"XXX", // 跳内容，当为H5链接时，当为APP动态页面是，为图片链接
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
    }
}

```

### (5)删除图片
```
Post /ota/appmgr/feixun_ai/banner/delete_picture
{
    "id":12121,
    "lastOptUid":4565, //操作人uid
    "real_name":"张三"  //操作人姓名
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
    }
}
```

## 3.渠道管理

### (1)添加渠道
```
Post /ota/appmgr/channel/add_channel
{
    "channel_name":"", // 渠道名称
    "channel_number":"", // 渠道号
    "file_url":"http://xxxx", //下载地址（非必填项）
    "lastOptUid":4565, //操作人uid
    "real_name":"张三"  //操作人姓名
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
    }
}
```
### (2)查询所有渠道的渠道号跟渠道名称
```
Post /ota/appmgr/channel/query_all_channel
响应参数
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
        "channels":[
            {
                "str_id":11, //渠道id
                "str_val":"android" //渠道名称
            },
            {
                "str_id":22, //渠道id
                "str_val":"android" //渠道名称
            }
        ]
    }
}
```
### (3)查询渠道信息
```
Post /ota/appmgr/channel/query_channel_info/{cur_page}/{page_size}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
        "total_count":10,
        "channels":[
            {
                "id":"1212",
                "channel_number":"qaqa", //渠道号
                "channel_name":"百度市场", //渠道名称
                "file_url":"http://xxxxx", //下载地址
                "last_opt_uid":4545646,//操作uid
                "last_opt_user_name":"张三" // 操作人名字
            },
            {
                "id":"1212",
                "channel_number":"qaqa", //渠道号
                "channel_name":"百度市场", //渠道名称
                "file_url":"http://xxxxx", //下载地址
                "last_opt_uid":4545646,//操作uid
                "last_opt_user_name":"张三" // 操作人名字
            }
        ]
    }
}
```
### (4)编辑渠道
```
Post /ota/appmgr/channel/edit_channel
{
    "id":123123
    "channel_name":"", // 渠道名称
    "channel_number":"", // 渠道号
    "file_url":"http://xxxx", //下载地址
    "lastOptUid":4565, //操作人uid
    "real_name":"张三"  //操作人姓名
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
    }
}
```
### (5)删除渠道
```
Post /ota/appmgr/channel/delete_channel
{
    "id":123123
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
    }
}
```
## 4.斐讯AI接口（语音指令）
### (1)添加和编辑指令
```
Post /ota/appmgr/feixun_ai/order/add_cmds
请求参数：
{
    "id":33 ,// 记录id，只在编辑时使用
    "title":"你好", // 标题
    "file":"xxx", // 图片文件
    "skill_introduction":"技能介绍", // 技能介绍
    "order_names":"小讯，小讯，今天天气怎么样|小讯，小讯，今天天气怎么样", // 语音指令，用"|"分隔
    "lastOptUid":4565, //操作人uid
    "real_name":"张三"  //操作人姓名
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功"
    }
}

```
### (2)编辑指令(不上传图片)
```
Post /ota/appmgr/feixun_ai/order/edit_cmds
请求参数：
{
    "id":33 ,// 记录id
    "title":"你好", // 标题
    "skill_introduction":"技能介绍", // 技能介绍
    "order_names":"小讯，小讯，今天天气怎么样|小讯，小讯，今天天气怎么样", // 语音指令，用"|"分隔
    "lastOptUid":4565, //操作人uid
    "real_name":"张三"  //操作人姓名
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功"
    }
}

```

### (3) 删除指令
```
Post /ota/appmgr/feixun_ai/order/delete_cmds
请求参数：
{
    "id":3 // 记录id
    "lastOptUid":4565, //操作人uid
    "real_name":"张三"  //操作人姓名
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功"
    }
}
```
### (4) 上移跟下移
```
Post /ota/appmgr/feixun_ai/order/move_cmds
请求参数：
{
    "up_id":3, // 上条记录id
    "up_sequence":3, // 上条排序值
    "down_id":4, // 下条记录id
    "down_sequence":5, // 下条排序值
    "lastOptUid":4565, //操作人uid
    "real_name":"张三"  //操作人姓名
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功"
    }
}
```

### (5)查询指令
```
Post /ota/appmgr/feixun_ai/order/query_cmds/{cur_page}/{page_size}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
        "total_count":10,
        "cmds": [
            {
                "id":33 ,// 记录id
                "title":"你好", // 标题
                "img_url":"xxx", // 图片url
                "skill_introduction":"技能介绍", // 技能介绍
                "order_names":"小讯，小讯，今天天气怎么样|小讯，小讯，今天天气怎么样", // 语音指令，用"|"分隔
                "sequence":1, // 排序值
                "file_name":"file_name", // 文件名称
                "lastOptUid":4565, //操作人uid
                "real_name":"张三",  //操作人姓名
                "create_time":"2017/12/18 12:30:00", // 创建时间
                "update_time":"2017/12/18 12:30:00", // 更新时间
            },
            {
                "id":33 ,// 记录id
                "title":"你好", // 标题
                "img_url":"xxx", // 图片url
                "skill_introduction":"技能介绍", // 技能介绍
                "order_names":"小讯，小讯，今天天气怎么样|小讯，小讯，今天天气怎么样", // 语音指令，用"|"分隔
                "sequence":2, // 排序值
                "file_name":"file_name", // 文件名称
                "lastOptUid":4565, //操作人uid
                "real_name":"张三",  //操作人姓名
                "create_time":"2017/12/18 12:30:00", // 创建时间
                "update_time":"2017/12/18 12:30:00", // 更新时间
            }
        ]          
    }
}
```

## 5.使用帮助
### (1) 添加和编辑使用帮助信息
```
Post /ota/appmgr/feixun_ai/use_help/add_help
请求参数：
{
    "id":1 , // 自增长id，只有编辑用到 
    "title":"你好", // 标题
    "html":"XXXX", // html页面字符串
    "content_url_list":[
        {
             "content":"", // 内容或者是url
             "type":"", // 文本内容还是图片url，"test"为文本，"pic"为图片url
        },
        {
             "content":"", // 内容或者是url
             "type":"", // 文本内容还是图片url，"test"为文本，"pic"为图片url
        },
    ], 
    "lastOptUid":4565, //操作人uid
    "real_name":"张三"  //操作人姓名
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功"
        "html":"xsxxxx" // html页面字符串
    }
}
```
### (2) 删除使用帮助信息
```
Post /ota/appmgr/feixun_ai/use_help/delete_help
请求参数：
{
    "id":1 , // 记录id
    "lastOptUid":4565, //操作人uid
    "real_name":"张三"  //操作人姓名
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功"
    }
}
```
### (3) 上移跟下移
```
Post /ota/appmgr/feixun_ai/use_help/move_help
请求参数：
{
    "up_id":3, // 上条记录id
    "up_sequence":3, // 上条排序值
    "down_id":4, // 下条记录id
    "down_sequence":5, // 下条排序值
    "lastOptUid":4565, //操作人uid
    "real_name":"张三"  //操作人姓名
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功"
    }
}
```
### (4) 查询使用帮助
```
Post /ota/appmgr/feixun_ai/use_help/query_use_help/{cur_page}/{page_size}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"，
    "total_count":10,
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
        "use_help_list":[
            {
                "id":121,
                "title":"你好",   // 标题
                "html":"",// 帮助内容
                "content_url_list":[
                    {
                         "content":"", // 内容或者是url
                         "type":"", // 文本内容还是图片url，"test"为文本，"pic"为图片url
                    },
                    {
                         "content":"", // 内容或者是url
                         "type":"", // 文本内容还是图片url，"test"为文本，"pic"为图片url
                    },
                ], 
                "lastOptUid":4565, //操作人uid
                "real_name":"张三",  //操作人姓名
                "create_time":"2017/12/18 12:30:00", // 创建时间
                "update_time":"2017/12/18 12:30:00", // 更新时间
            },
            {
                "id":121,
                "title":"你好",   // 标题
                "html":"",// 帮助内容
                "content_url_list":[
                    {
                         "content":"", // 内容或者是url
                         "type":"", // 文本内容还是图片url，"test"为文本，"pic"为图片url
                    },
                    {
                         "content":"", // 内容或者是url
                         "type":"", // 文本内容还是图片url，"test"为文本，"pic"为图片url
                    },
                ], 
                "lastOptUid":4565, //操作人uid
                "real_name":"张三",  //操作人姓名
                "create_time":"2017/12/18 12:30:00", // 创建时间
                "update_time":"2017/12/18 12:30:00", // 更新时间
            }
        ]
    }
}
```
### (5) 上传图片
```
Post /ota/appmgr/feixun_ai/banner/upload_original_picture
请求参数:
{
    "file":"xxxx" //  文件,跳转页图片
}
响应参数:
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功"
        "img":"http://xxxx" // 图片地址
    }
}
```

## 6.斐讯app-web兼容性调整接口

### (1)获取版本号列表接口
```
Post /ota/appmgr/web_app/order/get_version
请求参数：
{	
	"model_name": "00001", // 设备id（可为空）
}	
响应参数：
{
    "err_code": 200, 
    "err_msg": "成功", 
    "result": {
        "ret_code": 200, 
        "ret_msg": "成功",
        "model_list": [
            {
                " model_name": "排插"// 设备名称
            }, 
            {
                " model_name": "排插"// 设备名称
            }
        ], 
         "app_list": [
            {
              "app_version":"v1.1" //app版本号        
            }, 
            {
              "app_version":"v1.1" //app版本号
            }
        ],
        "h5_list": [
            {
                "h5_version ": "v1.1"// h5版本号
            }, 
            {
                "h5_version ": "v1.2"// h5版本号
            }
        ]
    }
}

```

### (2) 版本信息增加接口
```
Post /ota/appmgr/web_app/order/version_add
请求参数：
{
    "version_type":1 //版本类型 1-app，2-h5 (必填)
	"model_name": "00001", // 设备id(h5版本必填，app版本为空)
	"version": "v1.1" // 版本号(必填)
	"h5url": "https//...", // h5地址(h5版本必填，app版本为空)
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功"
    }
}
```


### (3) 版本信息删除接口
```
Post /ota/appmgr/web_app/order/version_del
请求参数：
{
	"model_name": "00001", // 设备名称 (必填)
	"version": "v1.1" // 版本号(必填)
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功"
    }
}
```
### (4)版本信息查询指令
```
Post /ota/appmgr/web_app/order/version_query_cmds/{cur_page}/{page_size}
请求参数：无
响应参数：
{
    "err_code": 200, 
    "err_msg": "成功", 
    "result": {
        "ret_code": 200, 
        "ret_msg": "成功", 
        "total_count": 10, 
        "list": [
            {
                "version_type": 1,  //版本类型 1-app，2-h5
                "model_name": "tc1", // 设备名称
                "version": "v1.1"// 版本号
                "h5url": "https//...", // h5地址
            }, 
            {
                "version_type": 1,  //版本类型 1-app，2-h5
                "model_name": "tc1", // 设备名称
                "version": "v1.1"// 版本号
                "h5url": "https//...", // h5地址
            }
        ]
    }
}
```

### (5) 版本关联关系增加接口
```
Post /ota/appmgr/web_app/order/versionship_add
请求参数：
{   "type ": 1, //为1时为修改操作
	"app_version ": "v1.1", // app版本号(必填)
	"model_name": "00001", // 设备名称 (必填)
	"h5_version": "v1.1", // h5版本号(必填)
	"h5url": "https//...", // 关联地址
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功"
    }
}
```






### (6)版本关联信息查询指令
```
Post /ota/appmgr/web_app/order/versionship_query_cmds/{cur_page}/{page_size}
请求参数：无
响应参数：
{
    "err_code": 200, 
    "err_msg": "成功", 
    "result": {
        "ret_code": 200, 
        "ret_msg": "成功", 
        "total_count": 10, 
        "list": [
            {
                "version_type": 1,  //版本类型 1-app，2-h5
                "version": "v1.1",  // 版本号
                "versionship": "v1.2", // 关联版本号
                "h5url": "https//...", // 关联地址
                "versionship_type": 1, //关联版本类型 1-app，2-h5    
                "modelship_name": "tc1" // 关联设备名称
            }, 
            {
                "version_type": 1, //版本类型 1-app，2-h5
                "version": "v1.1", // 版本号
                "versionship": "v1.2", // 关联版本号
                "h5url": "https//...", // 关联地址
                "versionship_type": 1, //关联版本类型 1-app，2-h5   
                "modelship_name": "tc1" // 关联设备名称
            }
        ]
    }
}
```

四、用户管理模块接口
====================

1.用户详情
----------

### (1)获取所有查询条件
```
Post /ota/usermgr/user_detail/get_query_term
响应参数：
{
    "err_code": 200,    
    "err_msg": "成功"    
    "result": {    
        "ret_code": 200,    
        "ret_msg": "成功",
        "jobs":[
            {
                "job":"-1",
                "job_val":"全部"
            },
            {
                "job":"后台",
                "job_val":"后台"
            },
            {
                "job":"前端",
                "job_val":"前端"
            }
        ]
    }
}
```
### (1)查询用户信息
```
Post /ota/usermgr/user_detail/query_user_info/{cur_page}/{page_size}
请求参数：
{
    "phone_number":"123545646", //手机号码
    "sex":"男", //性别
    "job":"IT男",//职业
    "birthday_start":"2017-01-01 22:30:00", //生日结束时间
    "birthday_end":"2017-01-03 22:30:00", //生日起始时间
    "register_start":"2017-01-01 22:30:00",//注册起始时间
    "register_end":"2017-01-03 22:30:00",//注册结束时间
    "product_type_id":1000  //产品类型id,1000为phihome产品，1001为斐讯ai产品
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
        "total_count":"10" //总页码
        "users":[ 
            {
                "id":1, //序号
                "uid":"120456", //用户id
                "phone_number":"231545666",//手机号码
                "nick_name":"张三", //张三
                "birthday":"2017-01-01 22:30:00", //生日
                "sex":"", // 性别
                "job":"IT男", //职业
                "register_time":"2017-01-01 22:30:00"，// 注册时间
                "bind_amount":3 //绑定设备的数量
            },
            {
                "id":1, //序号
                "uid":"120456", //用户uid
                "phone_number":"231545666",//手机号码
                "nick_name":"张三", //张三
                "birthday":"2017-01-01 22:30:00", //生日
                "sex":"", // 性别
                "job":"IT男", //职业  
                "register_time":"2017-01-01 22:30:00"，// 注册时间
                "bind_amount":3 //绑定设备的数量
            }
        ]
    }
}
```
### (3)查看该用户名下绑定的设备详细信息
```
Post /ota/usermgr/user_detail/query_user_bind_info
请求参数：
{
    "uid":"120145" //用户uid
    "product_type_id":1000 //产品类型id,1000为phihome产品，1001为斐讯ai产品
}
响应参数：
{
    "err_code": 200,
    "err_msg": "成功"
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
        "devices":[
            {
                "device_type":"outlet", // 产品名称
                "model":"T1", // 型号
                "hardware_version":"V1", // 硬件版本
                "rom_version":"1.0.0.1", // 固件版本号
                "device_id":"sdfsdf3423424", // 设备id
                "mac":"aa:vv:sd:dd:dd:dd:dd", //mac地址
                "area":"深圳",//地区
                "online_status":"1" //在线状态,1在线，0离线
            },
            {
                "device_type":"outlet", // 产品名称
                "model":"T1", // 型号
                "hardware_version":"V1", // 硬件版本
                "rom_version":"1.0.0.2", // 固件版本号
                "device_id":"sdfsdf3423424", // 设备id
                "mac":"aa:vv:sd:dd:dd:dd:dd", //mac地址
                "area":"深圳",//地区
                "online_status":"1" //在线状态,1在线，0离线
            }
        ]
    }
}
```

五、账户权限管理模块
============
## 1.用户登录
### (1) 用户登录
```
Post /ota/user_login
请求参数：
{
    "account":"",// 账号
 	"passwd":"",// 密码
}
//用户自定义返回，例子
response:
{
    "result": {
        "token": "",// 用户TOKEN（很重要）
        "ret_code": 200,
        "ret_msg": "成功",
        "uid": 100021,// 用户UID（很重要）
        "user_name": "",// 账号
        "real_name": "",// 用户真实姓名
        "email": "",// 邮箱
        "department": "",// 部门
        "face_img": "",// 头像
        "sex": 0,// 性别 1.男 2.女 0.其他
        "phone": "",// 手机
        "default_page_url":"",
        "status": 1,// 用户状态 1.正常 -1.暂停
        "editable":1,//记录是否可操作  0.可操作  1.不可操作
    },
    "err_code": 200,
    "err_msg": "成功"
}
```
### (2)用户登出
```

Post /ota/user_logout
请求参数：
{
    "userName":"",// 用户名
 	"token":"",// 用户token
}
//用户自定义返回，例子
response:
{
    "result": {
        "ret_code": 200,
        "ret_msg": "成功"
    },
    "err_code": 200,
    "err_msg": "成功"
}
```
### (3)检测用户登录状态
```

Post /ota/check_user_log_status
请求参数：
{
    "userName":"",// 用户名
 	"token":"",// 用户token
}
//用户自定义返回，例子
response:
{
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
        "status": 1,// 用户登录状态 1.登录正常或成功 -1.登陆失败或未登录
        "extendMsg":""// 登录状态信息
    },
    "err_code": 200,
    "err_msg": "成功"
}
```

## 2.账户详情
### (1)账户详情搜索条件信息
```

Post /ota/sys/query_sys_dprole_info
请求参数：无
//用户自定义返回，例子
response:
{
    "result": {
        "sysRoles": [
            {
                "strId": "1",
                "strValue": "超级管理员",// 角色名称
            }
        ],
        "allSysRoles": [// 带"全部"选项的角色集合
            {
               "strId": "-1",
               "strValue": "全部",
            }
        ],
        "sysDepartments": [// 部门信息
            "strId":""
            "strValue":"软件开发中心"
        ],
        "ret_code": 200,
        "ret_msg": "成功",
        "extend_msg": null
    },
    "err_code": 200,
    "err_msg": "操作成功"
}
```
### (2)查询系统用户信息列表
```

Post /ota/sys/query_sys_user_info
请求参数：
{
    "lastOptUid":0,// 操作人UID
    "email":"",// 邮箱，可为空（模糊匹配）
    "realName":"",// 真实姓名，可为空（模糊匹配）
    "department":"",// 部门名称
    "roleId":"",// 角色ID
    "pageSize":"",// 页大小
    "curPage":""// 当前第几页
}
//用户自定义返回，例子
response:
{
    "result": {
        "totalCount": 0,//总记录数
        "sysUsersInfo": [
            {
                "faceImg": "",// 用户头像
                "sex": 0,// 性别 1.男 2.女 0.其他
                "optTimeStr": "",// 操作时间
                "userName": "",// 用户账号
                "realName": "",// 真实姓名
                "uid": 0,// 用户UID
                "department": "",// 部门
                "email": "",// 邮箱
                "userRolesName":"",// 用户拥有角色名，多个用英文逗号隔开
                "userRoleIds":"",// 用户拥有角色ID，多个用英文逗号隔开
                "editable":1,// 记录是否可操作  0.可操作  1.不可操作
            }
        ],
        "ret_code": 200,
        "ret_msg": "成功",
        "extend_msg": null
    },
    "err_code": 200,
    "err_msg": "操作成功"
}
```
### (3)更新用户的角色
```

Post /ota/sys/update_user_roles
请求参数：
{
	"userName":"",// 操作人账户
	"token":"",// 操作人TOKEN
	"lastOptUid":0,// 操作人UID
	"uid":"",// 被更新用户的UID
	"roleIds":"",// 角色ID，多个ID英文逗号隔开
}
//用户自定义返回，例子
response:
{
    "result": {
        "ret_code": 200,
        "ret_msg": "成功"
    },
    "err_code": 200,
    "err_msg": "成功"
}
```
### (4)删除用户
```

Post /ota/sys/del_user
请求参数：
{
	"userName":"",// 操作人账户
	"lastOptUid":0,// 操作人UID
	"token":"",// 操作人TOKEN
	"uid":"",// 被删除用户UID
}
//用户自定义返回，例子
response:
{
    "result": {
        "ret_code": 200,
        "ret_msg": "成功"
    },
    "err_code": 200,
    "err_msg": "成功"
}
```

## 3.账户角色
### (1)添加角色所需权限信息
```

Post /ota/sys/query_role_need_auth_info
请求参数：
{
    "classify":"",// 分类ID（有则必传）
    "secondMenuId":""// 中间标题ID（有则必传）
}
//用户自定义返回，例子
response:
{
    "errCode": 200,
    "errMsg": "成功",
    "result": {
        "authTreeInfos": [
            {
                "children": [
                    {
                        "id": 2,
                        "label": "管理概况",
                        "parentId": 1
                    },
                    {
                        "id": 3,
                        "label": "查看App用户",
                        "parentId": 1
                    },
                    {
                        "id": 4,
                        "label": "查看打赏用户",
                        "parentId": 1
                    }
                ],
                "id": 1,
                "label": "数据统计",
                "parentId": 0
            },
            {
                "children": [
                    {
                        "id": 7,
                        "label": "查看打赏网络设置",
                        "parentId": 5
                    },
                    {
                        "id": 8,
                        "label": "查看对账列表",
                        "parentId": 5
                    }
                ],
                "id": 5,
                "label": "后台设置",
                "parentId": 0
            }
        ],
        "retCode": 200,
        "retMsg": "成功"
    }
}
```
### (2)添加角色
```

Post /ota/sys/add_role
请求参数：
{
	"userName":"",// 操作人账户
	"lastOptUid":0,// 操作人UID
	"token":"",// 操作人TOKEN
	"name":"",// 角色名称
	"authIds":"1,2,3,4"// 角色对应的权限ID，多个ID英文逗号隔开
}
//用户自定义返回，例子
response:
{
    "result": {
        "ret_code": 200,
        "ret_msg": "成功"
    },
    "err_code": 200,
    "err_msg": "成功"
}
```
### (3)查询角色列表
```

Post /ota/sys/query_sys_role_info_list
请求参数：
{
    "lastOptUid":0,// 操作人UID
    "pageSize":"",// 页大小
    "curPage":""// 当前第几页
}
//用户自定义返回，例子
response:
{
    "result": {
        "totalCount": 0,//总记录数
        "sysRoles": [
            {
                "optTimeStr": "",// 操作时间
                "name": "超级管理员",// 角色名称
                "id": 1,// 角色ID
                "roleAuthIds":""// 角色对应权限ID，多个英文逗号隔开
                "roleAuthNames":""// 角色对应权限名称，多个英文逗号隔开
                "editable":1// 记录是否可操作  0.可操作  1.不可操作
            }
        ],
        "ret_code": 200,
        "ret_msg": "成功"
    },
    "err_code": 200,
    "err_msg": "操作成功"
}
```
### (4)编辑角色
```

Post /ota/sys/edit_role
请求参数：
{
	"userName":"",// 操作人账户
	"lastOptUid":0,// 操作人UID
	"token":"",// 操作人TOKEN
	"id":"",// 角色ID
	"authIds":"1,2,3,4"// 角色对应的权限ID，多个ID英文逗号隔开;没有权限ID该字段为-1
}
//用户自定义返回，例子
response:
{
    "result": {
        "ret_code": 200,
        "ret_msg": "成功"
    },
    "err_code": 200,
    "err_msg": "成功"
}
```
### (5)查询系统所有角色信息
```

Post /ota/sys/query_sys_role_info
请求参数：无
//用户自定义返回，例子
response:
{
    "result": {
        "sysRoles": [
            {
                "strId": "1",
                "strValue": "超级管理员"
            },
            {
                "strId": "2",
                "strValue": "管理员"
            },
            {
                "strId": "3",
                "strValue": "普通用户"
            }
        ],
        "sysDepartments": null,
        "ret_code": 200,
        "ret_msg": "成功",
        "extend_msg": null
    },
    "err_code": 200,
    "err_msg": "操作成功"
}
```
### (6)删除角色
```

Post /ota/sys/del_role
请求参数：
{
	"userName":"",// 操作人账户
	"lastOptUid":0,// 操作人UID
	"token":"",// 操作人TOKEN
	"id":"",// 角色ID
}
//用户自定义返回，例子
response:
{
    "result": {
        "ret_code": 200,
        "ret_msg": "成功"
    },
    "err_code": 200,
    "err_msg": "成功"
}
```

## 4.账户权限
```
1 查询权限列表
Post /ota/sys/query_sys_authority_info_list
请求参数：
{
	"pageSize":"",//每页大小
	"curPage":"",//当前第几页
}
//用户自定义返回，例子
response:
{
    "result": {
        "totalCount": 0,//总记录数
        "sysAuthoritys": [
            {
                "id": 0,// 权限ID
                "descrb": "",// 权限名称
                "classify":0,// 分类ID
                "classifyName":"",// 分类名称
                "secondMenuId":0,// 中间标题ID
                "detail":0,// 详情ID
                "optTimeStr":"",// 操作时间
                "optType": 1,// 操作类型 1.查看 2.管理
            }
        "ret_code": 200,
        "ret_msg": "成功",
    },
    "err_code": 200,
    "err_msg": "操作成功"
}
```

## 5.系统菜单
### (1)查询用户菜单
```

Post /ota/sys/query_user_menus
请求参数：
{
	"lastOptUid":0,// 登录用户UID
}
//用户自定义返回，例子
response:
{
    "errCode": 200,
    "errMsg": "成功",
    "result": {
        "retCode": 200,
        "retMsg": "成功",
        "sysMenus": [
            {
                "childMenus": [// 子菜单
                    {
                        "childMenus": [// 子菜单
                            {
                                "id": 16,// 菜单ID
                                "name": "端口数据",// 菜单名称
                                "parentMenuId": 15,// 父菜单ID
                                "type": 3,// 菜单级别（如3代表3级菜单）
                                "icon": "",
                                "url": "/readme/portData"// 菜单链接
                            },
                            {
                                "id": 17,
                                "name": "电量数据",
                                "parentMenuId": 15,
                                "type": 3,
                                "url": "/readme/electricQuantityData"
                            }
                        ],
                        "id": 15,
                        "name": "智能排插",
                        "parentMenuId": 14,
                        "type": 2,
                        "url": ""
                    }
                ],
                "id": 14,
                "name": "统计分析",
                "parentMenuId": 0,
                "type": 1,
                "icon": "el-icon-phone-outline",// 菜单图标
                "url": ""
            },
            {
                "childMenus": [
                    {
                        "id": 33,
                        "name": "账户详情",
                        "parentMenuId": 32,
                        "type": 2,
                        "icon": "",
                        "url": "/readme/accountDetail"
                    }
                ],
                "id": 32,
                "name": "系统管理",
                "parentMenuId": 0,
                "type": 1,
                "icon": "el-icon-phone-outline",// 菜单图标
                "url": ""
            }
        ]
    }
}
```
### (2)校验用户页面权限
```

Post /ota/sys/check_sys_user_page_auth
请求参数：
{
	"userName":"",// 操作人账户
	"lastOptUid":0,// 操作人UID
	"token":"",// 操作人TOKEN
	"pageUrl":"",// 页面对应URL
}
//用户自定义返回，例子
response:
{
    "result": {
        "ret_code": 200,
        "ret_msg": "成功",
        "pageAuth":0,// 页面权限 0.无权限查看  1.可查看  2.可管理（包含查看权限）
    },
    "err_code": 200,
    "err_msg": "成功"
}
```
