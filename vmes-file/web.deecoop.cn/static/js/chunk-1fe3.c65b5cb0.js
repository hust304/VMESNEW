(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-1fe3"],{"0Tah":function(e,t,a){"use strict";var i=a("WHr9");a.n(i).a},M8FH:function(e,t,a){"use strict";a.r(t);a("f3/d"),a("rGqo");var i=a("uTIz"),s=a("2+ib"),o=a("Ah2L"),n=a("aCQO"),l=a("K3g7"),r=a("R1DK"),c=a("Vobf"),u=a("z0WU"),h={components:{searchBar:i.a,multilevelTable:s.a,dialogSafeStock:o.default,dialogStock:n.default},data:function(){return{guid:"",searchList:[{label:"货品编码",type:"input",mapKey:"code",configs:{},placeholder:"请输入货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"请输入货品名称"},{label:"货品属性",type:"cascader",mapKey:"genreSelect",configs:{clearable:!0,apiName:"getDictionarys",params:{dictionaryKey:"productGenre",isglobal:"1"}},placeholder:"请选择"},{label:"货品类型",type:"input",ruleType:"string",mapKey:"typeName",configs:{},placeholder:"请输入货品类型"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"spec",configs:{},placeholder:"请输入规格型号"},{label:"库存数量",type:"select",ruleType:"string",mapKey:"stockCountQuery",configs:{clearable:!0,name:"",options:[{value:"stockCountGreaterThanZero",label:"大于零"},{value:"stockCountZero",label:"等于零"},{value:"all",label:"全部"}]},placeholder:"请选择"},{label:"安全库存",type:"select",ruleType:"number",mapKey:"isSafeStock",configs:{clearable:!0,name:"",options:[{value:1,label:"小于安全库存"},{value:2,label:"大于等于安全库存"}]},placeholder:"请选择"}],searchConfig:{hideSearchSwitch:!1},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:null,tempLable:null,nodeId:null},configs:{topBarBtnList:[{name:"导出",nameEn:"export",isShow:!0,icon:"export",method:this.exportExcel}]},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},tableConfigList:[{customColumn:[{columnIndex:"stockCount",_cellConfig:{hideTitle:!0,contentSet:{state:{computed:"self@stockCount(-)self@safetyCount"},style:{color:'computed < 0 ? "#ff0000" : "inherit"'}}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"设置安全库存",nameEn:"resetSafeStock",editBtns_isShow:!0,method:this.resetSafeStock}]}],apiObj:{apiName:"listPageWarehouseProductView",params:{warehouseId:"",isNeedEntity:"true",isNotNeedSpare:"true",dataType:this.$storage.get("dataType")}},tempData:{},showHeader:!0,showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[],apiObj:{apiName:"listPageWarehouseDetailView",params:{warehouseId:"",fieldCode:"warehouseName,code,stockCount",stockCountQuery:"stockCountNotZero"}},dynamicValue:{productId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!1,isSingle:!1,componentId:"twoLevelTable"}],searchObj:{isNeedEntity:"true",isNotNeedSpare:"true"},selectList:[],temp:{},tempQuery:{},tempLable:{},pageData:null,pageNo:1}},beforeCreate:function(){},created:function(){this.initButtons(),this.initTree()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{exportExcel:function(){var e="";null!=this.tableData&&this.tableData.length>0&&this.tableData.forEach(function(t){e=e+t.id+","}),Object(r.exportExcelWarehouseProductByProduct)({ids:e,isNeedEntity:"true",isNotNeedSpare:"true"}).then(function(e){e&&Object(u.j)(e,"货品库存查询列表导出.xls")}).catch(function(e){})},resetSafeStock:function(e,t){this.dialogData.temp=e,this.dialogData.tempLable=this.tempLable,this.dialogData.title="安全库存调整",this.openDialogName="dialogSafeStock",this.showDialog=!0,this.visible=!0},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.searchObj.isNeedEntity="true",this.searchObj.isNotNeedSpare="true",this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},searchMap:function(e){this.searchObj=e,this.tableConfigList[0].apiObj.params.warehouseId=this.selectTree.id,this.tableConfigList[1].apiObj.params.warehouseId=this.selectTree.id,this.updateData(this.searchObj)},sendGuid:function(e){this.guid=e},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&(this.tableConfigList[0].apiObj.params.warehouseId=this.selectTree.id,this.tableConfigList[1].apiObj.params.warehouseId=this.selectTree.id,this.updateData(this.searchObj))},initButtons:function(){var e=this,t=e.$storage.get("userInfo").roleIds,a=e.$storage.get("menuId");t&&(e.$loading({spinner:"preloader",text:""}),Object(c.initMenuButtons)({menuId:a,roleId:t}).then(function(t){e.$loading().close();var a=t.buttonList;a&&a.forEach(function(t){e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)})),e.tableConfigList&&e.tableConfigList.forEach(function(e){e.customColumn&&e.customColumn.forEach(function(e){"last"==e.columnIndex&&e.component&&e.component.forEach(function(e){e.nameEn==t.nameEn&&(e.rowState="1==2")})})})})}).catch(function(t){e.$loading().close()}))},initTree:function(){var e=this;Object(l.treeWarehouse)({id:"2d75e49bcb9911e884ad00163e105f05",isNeedEntity:"true",isNotNeedSpare:"true"}).then(function(t){var a=[],i=t.result.treeList;e.selectTree={pid:i.pid,id:i.id,layer:i.layer,name:i.name,virtualGenre:i.virtualGenre},a.push(i),e.treeData=a,e.$nextTick(function(){e.$refs.tree.$children[0].setCurrentKey(e.selectTree.id)}),e.$loading().close()}).catch(function(t){e.$loading().close()})},treeDataBridge:function(e){this.selectTree={pid:e.nodeData.pid,id:e.nodeData.id,layer:e.nodeData.layer,name:e.nodeData.name,pathId:e.nodeData.pathId},this.pageNo=1,this.tableConfigList[0].apiObj.params.warehouseId=this.selectTree.id,this.tableConfigList[1].apiObj.params.warehouseId=this.selectTree.id,this.updateData(this.searchObj)},databridge:function(e){this.selectList=e}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}},d=(a("j1XY"),a("0Tah"),a("KHd+")),p=Object(d.a)(h,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"stockQueryByWC"},[e.searchList.length?a("search-bar",{attrs:{searchList:e.searchList,searchConfig:e.searchConfig},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[a("el-col",{staticClass:"treeStyle",attrs:{span:4}},[a("base-tree",{ref:"tree",attrs:{data:e.treeData,treeConfigs:e.treeConfigs},on:{treedatabridge:e.treeDataBridge}})],1),e._v(" "),a("el-col",{staticStyle:{height:"100%",position:"relative"},attrs:{span:20}},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableTopBar"},[a("el-col",[a("div",{staticClass:"tableBtns"},[e._l(e.configs.topBarBtnList,function(e,t){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state},on:{myclick:e.method}})]})],2)])],1),e._v(" "),a("el-col",{staticClass:"tableStyle"},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_warehouseByWC_stockQueryByWC_index0",tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1)],1)])],1)])],1),e._v(" "),e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);p.options.__file="index.vue";t.default=p.exports},WHr9:function(e,t,a){},j1XY:function(e,t,a){"use strict";var i=a("jLMZ");a.n(i).a},jLMZ:function(e,t,a){}}]);