(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-5c05","Gr86","fFEi"],{"59hd":function(e,t,i){"use strict";i.r(t);i("91GP"),i("rGqo");var a=i("zDZ1"),s=i("lX1r"),o=i("uTIz"),l=i("fFEi"),n=i("Gr86"),r=i("AUoE"),c=i("Vobf");i("z0WU");function d(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}var p={props:["colConfig"],template:'<el-table-column :label="colConfig.label" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t    <el-button v-show="colConfig.infoByParent_isShow" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.infoByParent(scope.row,scope.$index)">详情</el-button>\n    \t\t\t\t\t    \x3c!--<el-button v-show="colConfig.editByParent_isShow && scope.row.state == \'0\'" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.editByParent(scope.row,scope.$index)">编辑</el-button>--\x3e\n    \t\t\t\t\t    \x3c!--<el-button v-show="colConfig.deleteByParent_isShow && (scope.row.state == \'0\' || scope.row.state == \'-1\')" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.deleteByParent(scope.row,scope.$index)">删除</el-button>--\x3e\n    \t\t\t\t\t\t\t<el-button v-show="colConfig.cancelByParent_isShow && scope.row.state == \'0\'" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.cancelByParent(scope.row,scope.$index,scope)">取消</el-button>\n    \t\t\t\t\t\t\t\x3c!--<el-button v-show="colConfig.recoveryByParent_isShow && scope.row.state == \'-1\'" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.recoveryByParent(scope.row,scope.$index,scope)">恢复</el-button>--\x3e\n    \t\t\t\t\t</div>\n  \t\t\t\t</el-table-column>'},u={components:{dialogQrcode:a.a,expandTable:s.a,searchBar:o.a,dialogAdd:l.default,dialogDeliverInfo:n.default},data:function(){var e;return d(e={colConfigs:[],initData:{},childrenDialogTitleList:[],fromTemp:{},showDialog:!1,dialogVisible:!1,dialogCallBackData:null,baseLayer:0,searchList:[{label:"订单编号",type:"input",ruleType:"string",mapKey:"deliverCode",configs:{},placeholder:"发货单编号"},{label:"客户名称",type:"input",ruleType:"string",mapKey:"customerName",configs:{},placeholder:"客户名称"},{label:"发货状态",type:"select",ruleType:"string",mapKey:"detailState",configs:{clearable:!0,name:"",options:[{value:"0",label:"待发货"},{value:"1",label:"已发货"},{value:"-1",label:"已取消"}]},placeholder:"请选择"},{label:"发货日期起",type:"date",ruleType:"date",mapKey:"deliverDateBegin",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"},{label:"发货日期止",type:"date",ruleType:"date",mapKey:"deliverDateEnd",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"}],guid:"",currentpage:1,maxLayer:2,expandTableApiList:["listPageSaleDeliver","listPageSaleDeliverDetail"],expandTableApiParams:[{priceType:"1"},{parentId:""}],initParams:{},updateViewData:{},searchObj:{},titleList:[],pageData:{},childrenData:{},customColumn:{1:[{columnIndex:"last",prop:"operate",label:"操作",component:p,infoByParent:this.infoByParent,infoByParent_isShow:!0,cancelByParent:this.cancelByParent,cancelByParent_isShow:!0}]},tableSets:{1:{showCheckBox:!0,expandOne:!1,isSingle:!0},2:{showCheckBox:!1,isExpands:!1,isSortable:!1,isSingle:!1}},configs:{topBarBtnList:[{name:"发货",nameEn:"add",isShow:!0,icon:"add",method:this.dialogAdd}],tableConfigs:[],showCheckBox:!1},temp:{},openDialogName:""},"showDialog",!1),d(e,"visible",!1),d(e,"dialogData",{title:"",deliverId:"",customerId:"",temp:null,tempLable:null}),e},beforeCreate:function(){},created:function(){this.initButtons(),this.initExpandTable()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var e=this;e.$loading({spinner:"none",text:"智 造 云 管 家"});var t=e.$storage.get("userInfo").roleIds,i=e.$storage.get("menuId");t&&Object(c.initMenuButtons)({menuId:i,roleId:t}).then(function(t){var i=t.buttonList;i&&i.forEach(function(t){if(e.initConfigs&&e.initConfigs.tableOperates)for(var i in e.initConfigs.tableOperates)i.indexOf(t.nameEn)>=0&&i.indexOf("isShow")>0&&(e.initConfigs.tableOperates[i]=!1);if(e.customColumn)for(var a in e.customColumn)if(a){var s=e.customColumn[a];s.length>0&&s.forEach(function(e){if(e)for(var i in e)i.indexOf(t.nameEn)>=0&&i.indexOf("isShow")>0&&(e[i]=!1)})}e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}))})}).catch(function(t){e.$loading().close()})},initExpandTable:function(){var e=this;this.$api[this.expandTableApiList[0]](this.setParams(1,this.expandTableApiParams[0],this.currentpage)).then(function(t){e.initData={row:null,layer:1,res:t,customColumn:e.customColumn},e.$loading().close()}).catch(function(t){e.$loading().close()})},databridge:function(e){this.temp.dataList=e},findChildByRow:function(e,t,i,a,s){var o=this;this.$api[this.expandTableApiList[t-1]](this.setParams(t,e,s)).then(function(i){o.childrenData={row:e,layer:t,res:i,customColumn:o.customColumn}}).catch(function(e){})},setParams:function(e,t,i){var a=Object.assign({},this.expandTableApiParams[e-1]);for(var s in a)a.hasOwnProperty(s)&&!a[s]&&(a[s]=t[s]||"");return Object.assign({},a,this.searchObj,{pageNo:i})},sendGuid:function(e){this.guid=e},searchMap:function(e){this.searchObj=e,this.initExpandTable()},resetTemp:function(){for(var e in this.temp)this.temp[e]=""},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&this.initExpandTable()},dialogAdd:function(){if(null==this.temp.dataList||0==this.temp.dataList.length||this.temp.dataList.length>1)this.$message({type:"warning",duration:5e3,showClose:!0,message:"请选择一条发货单数据！"});else{var e=this.temp.dataList[0].id,t=this.temp.dataList[0].customerId;this.dialogData.deliverId=e,this.dialogData.customerId=t,this.dialogData.title="发货方式",this.openDialogName="dialogAdd",this.showDialog=!0,this.visible=!0}},infoByParent:function(e,t){this.dialogData.temp=e,this.dialogData.title="发货详情",this.openDialogName="dialogDeliverInfo",this.showDialog=!0,this.visible=!0},cancelByParent:function(e,t){var i=this;this.$storage.get("userInfo").userId==e.makeId?this.$confirm("此操作将订单状态变更为已取消, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(r.cancelSaleDeliver)(e.id).then(function(e){0===e.code&&(i.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),i.initExpandTable())}).catch(function(e){})}).catch(function(){i.$message({type:"info",message:"已取消操作"})}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"您不是制单人不可取消！"})},executorByDetail:function(e,t){this.resetTemp(),this.dialogData.temp=e,this.dialogData.tempLable=this.tempLable,this.dialogData.title="查看执行人",this.openDialogName="dialogViewExecutor",this.showDialog=!0,this.visible=!0},exportExcel:function(){}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{currentpage:function(){this.initExpandTable()}}},m=(i("uLJj"),i("KHd+")),h=Object(m.a)(u,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"createDeliver"},[e.searchList.length?i("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[e._l(e.configs.topBarBtnList,function(e,t){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state},on:{myclick:e.method}})]})],2)])],1),e._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[i("el-col",{staticClass:"tableStyle"},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableContent"},[i("expand-table",{attrs:{initData:e.initData,childrenData:e.childrenData,configs:e.tableSets,currentpage:e.currentpage,maxLayer:e.maxLayer,apiObj:{apiName:e.expandTableApiList,apiParams:e.expandTableApiParams},updateViewData:e.updateViewData},on:{"update:currentpage":function(t){e.currentpage=t},databridge:e.databridge,"send-children-row":e.findChildByRow}})],1)],1)])],1),e._v(" "),e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);h.options.__file="index.vue";t.default=h.exports},"9WTv":function(e,t,i){"use strict";i.d(t,"d",function(){return s}),i.d(t,"a",function(){return o}),i.d(t,"f",function(){return l}),i.d(t,"e",function(){return n}),i.d(t,"b",function(){return r}),i.d(t,"c",function(){return c});var a=i("t3Un");function s(e){return Object(a.a)({url:"/equipment/listPageEquipments",method:"post",data:e})}function o(e){return Object(a.a)({url:"/equipment/addEquipment",method:"post",data:e})}function l(e){return Object(a.a)({url:"/equipment/updateEquipment",method:"post",data:e})}function n(e,t){return Object(a.a)({url:"/equipment/update",method:"post",data:{id:e,isdisable:t}})}function r(e){return Object(a.a)({url:"/equipment/deleteByIds",method:"post",data:{ids:e}})}function c(e){return Object(a.a)({url:"/equipment/exportExcelEquipments",method:"post",responseType:"blob",data:{ids:e}})}},Gr86:function(e,t,i){"use strict";i.r(t);i("RW0V"),i("rE2o"),i("ioFf"),i("rGqo"),i("yt8O"),i("XfO3"),i("9AAn");var a=i("OsNz"),s=i("z0WU"),o=i("mSNy");function l(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}function n(e){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var r={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{parentId:"",isShowSend:!1,isShowDeliver:!1,isShowSelf:!1,deliverTypeKeyNameMap:new Map([["1","send"],["2","deliver"],["3","self"]]),rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,isNeedRepeat:!1,tempLable:null},dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempQuery:{},tableData:[],selectList:null,initConfigs:{tableOperates:{}},configs:{tableConfigs:[],showCheckBox:!1,showIndex:!1},pageData:null,pageNo:1}},created:function(){this.temp=this.initData.temp,this.parentId=this.initData.temp.id;var e=this.deliverTypeKeyNameMap.get(this.initData.temp.type);"send"==e?this.isShowSend=!0:"deliver"==e?this.isShowDeliver=!0:"self"==e&&(this.isShowSelf=!0),this.initTable()},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=n(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(s.j)(e.result),i=this.addTableTitle(t);this.configs.tableConfigs=i,this.tableData=e.result.varList,this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})}},initTempData:function(e){var t=this;e.forEach(function(e){for(var i in e){var a=e[i];a.indexOf("_")>0&&("en"==o.a.locale?a=a.substring(a.indexOf("_")+1):"zh"==o.a.locale&&(a=a.substring(0,a.indexOf("_")))),t.tempLable[i]=a}})},addTableTitle:function(e){return e.forEach(function(e){var t=e.label;t.indexOf("_")>0&&("en"==o.a.locale?e.label=t.substring(t.indexOf("_")+1):"zh"==o.a.locale&&(e.label=t.substring(0,t.indexOf("_"))))}),this.internationalConfig(),e},internationalConfig:function(){"en"==o.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==o.a.locale&&(this.initConfigs.tableOperates.label="操作")},initTable:function(){var e=this;this.$loading({spinner:"none",text:"智 造 云 管 家"}),Object(a.listPageSaleDeliverDetail)(function(e){for(var t=1;t<arguments.length;t++){var i=null!=arguments[t]?arguments[t]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(e){return Object.getOwnPropertyDescriptor(i,e).enumerable}))),a.forEach(function(t){l(e,t,i[t])})}return e}({},this.tempQuery,{parentId:this.parentId,pageNo:this.pageNo})).then(function(t){e.getListPage(t),e.$loading().close()}).catch(function(t){e.$loading().close()})},dataBridge:function(e){},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},closeDialog:function(e){}},watch:{pageNo:function(){this.initTable("add","")}}},c=i("KHd+"),d=Object(c.a)(r,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"发货单编号：",prop:"deliverCode"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{disabled:!0},model:{value:e.temp.deliverCode,callback:function(t){e.$set(e.temp,"deliverCode",t)},expression:"temp.deliverCode"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"客户名称：",prop:"customerName"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{disabled:!0},model:{value:e.temp.customerName,callback:function(t){e.$set(e.temp,"customerName",t)},expression:"temp.customerName"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"客户类型：",prop:"customerTypeName"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{disabled:!0},model:{value:e.temp.customerTypeName,callback:function(t){e.$set(e.temp,"customerTypeName",t)},expression:"temp.customerTypeName"}})],1)],1)],1),e._v(" "),i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"发货类型：",prop:"typeName"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{disabled:!0},model:{value:e.temp.typeName,callback:function(t){e.$set(e.temp,"typeName",t)},expression:"temp.typeName"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"经办人：",prop:"makeName"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{disabled:!0},model:{value:e.temp.makeName,callback:function(t){e.$set(e.temp,"makeName",t)},expression:"temp.makeName"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"发货日期：",prop:"deliverDate"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{disabled:!0},model:{value:e.temp.deliverDate,callback:function(t){e.$set(e.temp,"deliverDate",t)},expression:"temp.deliverDate"}})],1)],1)],1),e._v(" "),i("el-row",{directives:[{name:"show",rawName:"v-show",value:e.isShowSend,expression:"isShowSend"}]},[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"物流公司：",prop:"waybillCompany"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{disabled:!0},model:{value:e.temp.waybillCompany,callback:function(t){e.$set(e.temp,"waybillCompany",t)},expression:"temp.waybillCompany"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"物流单号：",prop:"waybillCode"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{disabled:!0},model:{value:e.temp.waybillCode,callback:function(t){e.$set(e.temp,"waybillCode",t)},expression:"temp.waybillCode"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"收货地址：",prop:"custAddress"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{disabled:!0},model:{value:e.temp.custAddress,callback:function(t){e.$set(e.temp,"custAddress",t)},expression:"temp.custAddress"}})],1)],1)],1),e._v(" "),i("el-row",{directives:[{name:"show",rawName:"v-show",value:e.isShowSend,expression:"isShowSend"}]},[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"联系人：",prop:"custAddressName"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{disabled:!0},model:{value:e.temp.custAddressName,callback:function(t){e.$set(e.temp,"custAddressName",t)},expression:"temp.custAddressName"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"手机号：",prop:"custMobile"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{disabled:!0},model:{value:e.temp.custMobile,callback:function(t){e.$set(e.temp,"custMobile",t)},expression:"temp.custMobile"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}})],1),e._v(" "),i("el-row",{directives:[{name:"show",rawName:"v-show",value:e.isShowDeliver,expression:"isShowDeliver"}]},[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"车牌号：",prop:"carCode"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{disabled:!0},model:{value:e.temp.carCode,callback:function(t){e.$set(e.temp,"carCode",t)},expression:"temp.carCode"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"收货地址：",prop:"custAddress"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{disabled:!0},model:{value:e.temp.custAddress,callback:function(t){e.$set(e.temp,"custAddress",t)},expression:"temp.custAddress"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"联系人：",prop:"custAddressName"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{disabled:!0},model:{value:e.temp.custAddressName,callback:function(t){e.$set(e.temp,"custAddressName",t)},expression:"temp.custAddressName"}})],1)],1)],1),e._v(" "),i("el-row",{directives:[{name:"show",rawName:"v-show",value:e.isShowDeliver,expression:"isShowDeliver"}]},[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"手机号：",prop:"custMobile"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{disabled:!0},model:{value:e.temp.custMobile,callback:function(t){e.$set(e.temp,"custMobile",t)},expression:"temp.custMobile"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}}),e._v(" "),i("el-col",{attrs:{span:8}})],1),e._v(" "),i("el-row",{directives:[{name:"show",rawName:"v-show",value:e.isShowSelf,expression:"isShowSelf"}]},[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"车牌号：",prop:"carCode"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{disabled:!0},model:{value:e.temp.carCode,callback:function(t){e.$set(e.temp,"carCode",t)},expression:"temp.carCode"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}}),e._v(" "),i("el-col",{attrs:{span:8}})],1),e._v(" "),i("el-row",{staticClass:"tableContent",staticStyle:{height:"450px",width:"96%","margin-left":"2%"}},[i("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);d.options.__file="dialogDeliverInfo.vue";t.default=d.exports},fFEi:function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf"),i("f3/d"),i("rGqo"),i("yt8O"),i("XfO3"),i("9AAn");var a=i("AUoE");function s(e){return(s="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var o={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{deliverId:"",customerId:"",deliverType:"send",deliverTypeNameKeyMap:new Map([["send","1"],["deliver","2"],["self","3"]]),isShowSend:!0,isShowDeliver:!1,isShowSelf:!1,dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{deliverId:"",type:"",makeId:"",makeName:"",deliverDate:"",waybillCompany:"",waybillCode:"",customeAddressId:"",custAddress:"",custAddressName:"",custMobile:"",carCode:"",remark:""},tempLable:{},tempNotEditable:{},rules:{makeName:[{required:!0,message:"请选择经办人",trigger:"change"}],deliverDate:[{required:!0,message:"请填写发货日期",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",fullscreen:!1,tempLable:null},formTemp:[],MakeDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择经办人",tableUrl:"/user/listPageUsers",tableParm:{fieldCode:"code,name,mobile,email,deptName,remark"},temp:{}},dialogName:"dialogOption"}},CustAddressDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择收货地址",tableUrl:"/customeAddress/listPageCustomeAddress",tableParm:{customerId:"",fieldCode:"name,mobile,address"},temp:{}},dialogName:"dialogOption"}}}},created:function(){this.deliverId=this.initData.deliverId,this.customerId=this.initData.customerId,this.CustAddressDialog.dialog.data.tableParm.customerId=this.initData.customerId},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=s(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},radioChange:function(){this.isShowSend=!1,this.isShowDeliver=!1,this.isShowSelf=!1,"send"==this.deliverType?this.isShowSend=!0:"deliver"==this.deliverType?this.isShowDeliver=!0:"self"==this.deliverType&&(this.isShowSelf=!0)},makeSelect:function(e){e[0]&&(this.temp.makeId=e[0].id,this.temp.makeName=e[0].name)},custAddressSelect:function(e){e[0]&&(this.temp.customeAddressId=e[0].id,this.temp.custAddressName=e[0].name,this.temp.custMobile=e[0].mobile,this.temp.custAddress=e[0].address)},save:function(){var e=this;this.dialogLoading=!0,this.temp.deliverId=this.deliverId,this.temp.type=this.deliverTypeNameKeyMap.get(this.deliverType),Object(a.updateSaleDeliverByDeliverType)(this.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"保存成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){e.dialogLoading=!1})},closeDialog:function(e){this.showDialog=!1}}},l=i("KHd+"),n=Object(l.a)(o,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"新增",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"400px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{height:"600px"}},[i("el-form",{ref:"submitForm",attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[i("el-row",{staticStyle:{margin:"30px 50px"}},[i("el-radio-group",{on:{change:e.radioChange},model:{value:e.deliverType,callback:function(t){e.deliverType=t},expression:"deliverType"}},[i("el-radio",{attrs:{label:"send"}},[e._v("发货")]),e._v(" "),i("el-radio",{attrs:{label:"deliver"}},[e._v("送货")]),e._v(" "),i("el-radio",{attrs:{label:"self"}},[e._v("客户自提")])],1)],1),e._v(" "),i("div",{staticStyle:{height:"500px"}},[i("el-form-item",{attrs:{label:"经办人：",prop:"makeName"}},[i("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:e.MakeDialog.dialog},on:{callback:e.makeSelect},model:{value:e.temp.makeName,callback:function(t){e.$set(e.temp,"makeName",t)},expression:"temp.makeName"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"发货日期：",prop:"deliverDate"}},[i("el-date-picker",{staticStyle:{width:"200px"},attrs:{type:"date",placeholder:"发货日期","value-format":"yyyy-MM-dd"},model:{value:e.temp.deliverDate,callback:function(t){e.$set(e.temp,"deliverDate",t)},expression:"temp.deliverDate"}})],1),e._v(" "),i("el-row",{directives:[{name:"show",rawName:"v-show",value:e.isShowSend,expression:"isShowSend"}]},[i("el-form-item",{attrs:{label:"物流公司：",prop:"waybillCompany"}},[i("el-input",{staticStyle:{width:"200px"},model:{value:e.temp.waybillCompany,callback:function(t){e.$set(e.temp,"waybillCompany",t)},expression:"temp.waybillCompany"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"物流单号：",prop:"waybillCode"}},[i("el-input",{staticStyle:{width:"200px"},model:{value:e.temp.waybillCode,callback:function(t){e.$set(e.temp,"waybillCode",t)},expression:"temp.waybillCode"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"收货地址：",prop:"custAddress"}},[i("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:e.CustAddressDialog.dialog},on:{callback:e.custAddressSelect},model:{value:e.temp.custAddress,callback:function(t){e.$set(e.temp,"custAddress",t)},expression:"temp.custAddress"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"联系人：",prop:"custAddressName"}},[i("el-input",{staticStyle:{width:"200px"},model:{value:e.temp.custAddressName,callback:function(t){e.$set(e.temp,"custAddressName",t)},expression:"temp.custAddressName"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"手机号：",prop:"custMobile"}},[i("el-input",{staticStyle:{width:"200px"},model:{value:e.temp.custMobile,callback:function(t){e.$set(e.temp,"custMobile",t)},expression:"temp.custMobile"}})],1)],1),e._v(" "),i("el-row",{directives:[{name:"show",rawName:"v-show",value:e.isShowDeliver,expression:"isShowDeliver"}]},[i("el-form-item",{attrs:{label:"车牌号：",prop:"carCode"}},[i("el-input",{staticStyle:{width:"200px"},model:{value:e.temp.carCode,callback:function(t){e.$set(e.temp,"carCode",t)},expression:"temp.carCode"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"收货地址：",prop:"custAddress"}},[i("el-input",{staticStyle:{width:"200px"},model:{value:e.temp.custAddress,callback:function(t){e.$set(e.temp,"custAddress",t)},expression:"temp.custAddress"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"联系人：",prop:"custAddressName"}},[i("el-input",{staticStyle:{width:"200px"},model:{value:e.temp.custAddressName,callback:function(t){e.$set(e.temp,"custAddressName",t)},expression:"temp.custAddressName"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"手机号：",prop:"custMobile"}},[i("el-input",{staticStyle:{width:"200px"},model:{value:e.temp.custMobile,callback:function(t){e.$set(e.temp,"custMobile",t)},expression:"temp.custMobile"}})],1)],1),e._v(" "),i("el-row",{directives:[{name:"show",rawName:"v-show",value:e.isShowSelf,expression:"isShowSelf"}]},[i("el-form-item",{attrs:{label:"车牌号：",prop:"carCode"}},[i("el-input",{staticStyle:{width:"200px"},model:{value:e.temp.carCode,callback:function(t){e.$set(e.temp,"carCode",t)},expression:"temp.carCode"}})],1)],1),e._v(" "),i("el-form-item",{attrs:{label:"备注：",prop:"remark"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{type:"textarea",rows:"2"},model:{value:e.temp.remark,callback:function(t){e.$set(e.temp,"remark",t)},expression:"temp.remark"}})],1)],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);n.options.__file="dialogAdd.vue";t.default=n.exports},lZYi:function(e,t,i){"use strict";var a=i("wnxv");i.n(a).a},qG3H:function(e,t,i){"use strict";var a=i("qltN");i.n(a).a},qltN:function(e,t,i){},uLJj:function(e,t,i){"use strict";var a=i("zCfb");i.n(a).a},wnxv:function(e,t,i){},zCfb:function(e,t,i){},zDZ1:function(e,t,i){"use strict";i("rE2o"),i("ioFf"),i("f3/d"),i("9WTv");function a(e){return(a="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var s={name:"dialog-add",props:["initData","visible"],components:{},data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},tempShow:{},rules:{},imageUrl:""}},created:function(){this.initData.temp&&(this.temp=this.initData.temp,this.initData.temp.qrcode&&(this.imageUrl="http://116.196.105.79:8080/"+this.initData.temp.qrcode)),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=a(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},download:function(){var e=this.imageUrl,t=document.createElement("a");t.style.display="none",t.href=e,t.setAttribute("download",this.temp.name),document.body.appendChild(t),t.click()},print:function(){var e=document.getElementById("printContent").innerHTML,t=document.body.innerHTML;return document.body.innerHTML=e,window.print(),window.location.reload(),document.body.innerHTML=t,!1}}},o=(i("lZYi"),i("qG3H"),i("KHd+")),l=Object(o.a)(s,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"二维码",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"400px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("div",{attrs:{id:"printContent"}},[i("el-form",{ref:"submitForm",staticStyle:{width:"400px",margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{staticStyle:{"text-align":"center","padding-bottom":"20px"},attrs:{span:24}},[e.imageUrl?i("img",{staticClass:"avatar",staticStyle:{margin:"0 auto"},attrs:{src:e.imageUrl}}):i("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1),e._v(" "),i("el-row",[i("el-col",{attrs:{span:24}},[i("b",{staticStyle:{"padding-left":"35%"}},[e._v(e._s(e.tempLable.code)+":")]),e._v(e._s(e.temp.code)),i("br"),e._v(" "),i("b",{staticStyle:{"padding-left":"35%"}},[e._v(e._s(e.tempLable.name)+":")]),e._v(e._s(e.temp.name)+"\n\n          ")])],1)],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center",padding:"15px 0 15px 0"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.download}},[e._v("下载")]),e._v(" "),i("el-button",{attrs:{type:"primary"},on:{click:e.print}},[e._v("打印")])],1)])])},[],!1,null,"56ed280a",null);l.options.__file="dialogQrcode.vue";t.a=l.exports}}]);