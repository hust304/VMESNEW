(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-d863"],{"+bMf":function(e,t,a){"use strict";a.d(t,"b",function(){return o}),a.d(t,"a",function(){return n});var i=a("t3Un");function o(e){return Object(i.a)({url:"/sale/saleRetreatAudit/auditPassSaleRetreat",method:"post",data:e})}function n(e){return Object(i.a)({url:"/sale/saleRetreatAudit/auditDisagreeSaleRetreat",method:"post",data:e})}},"8P3P":function(e,t,a){},IZi7:function(e,t,a){"use strict";a.r(t);a("rGqo"),a("yt8O"),a("XfO3"),a("9AAn");var i=a("2+ib"),o=a("uTIz"),n=a("QjqE"),s=(a("+bMf"),a("Vobf")),l=(a("z0WU"),{components:{multilevelTable:i.a,searchBar:o.a,dialogMoneyRetreat:n.default},data:function(){return{retreatStateNameMap:new Map([["0","待提交"],["1","待审核"],["2","待退款"],["3","已完成"],["-1","已取消"]]),searchList:[{label:"退货编号",type:"input",ruleType:"string",mapKey:"sysCode",configs:{},placeholder:"退货编号"},{label:"客户名称",type:"input",ruleType:"string",mapKey:"customerName",configs:{},placeholder:"客户名称"},{label:"退货单状态",type:"select",ruleType:"string",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"0",label:"待提交"},{value:"1",label:"待审核"},{value:"2",label:"待退款"},{value:"3",label:"已完成"},{value:"-1",label:"已取消"}]},placeholder:"请选择"},{label:"制单日期起",type:"date",ruleType:"date",mapKey:"cdateBegin",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"},{label:"制单日期止",type:"date",ruleType:"date",mapKey:"cdateEnd",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"}],guid:"",tableConfigList:[{customColumn:[{columnIndex:"sysCode"},{columnIndex:"customerName"},{columnIndex:"cdateStr"},{columnIndex:"retreatDateStr"},{columnIndex:"remark"},{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},default:{state:"0",text:"待提交"},info1:{state:"1",text:"待审核"},info2:{state:"2",text:"待退款"},info:{state:"-1",text:"已取消"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"退款",nameEn:"moneyRetreatByParent",editBtns_isShow:!0,icon:"moneyRetreatByParent",method:this.moneyRetreatByParent}]}],apiObj:{apiName:"listPageSaleRetreat",params:{state:"2"}},tempData:{},showHeader:!1,showIndex:!0,showCheckBox:!0,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},default:{state:"0",text:"待提交"},info1:{state:"1",text:"待审核"},info2:{state:"2",text:"待退款"},info:{state:"-1",text:"已取消"}}}],apiObj:{apiName:"listPageSaleRetreatDetail",params:{}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!1,isSingle:!1,componentId:"twoLevelTable"}],searchObj:{},selectList:[],configs:{topBarBtnList:[],tableConfigs:[],showCheckBox:!1},openDialogName:"",showDialog:!1,visible:!1,dialogData:{dialog_width:"",orderDetail_style:"",title:"",data:{},tempLable:null},tableData:[],rowTableList:[]}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var e=this,t=e.$storage.get("userInfo").roleIds,a=e.$storage.get("menuId");t&&(e.$loading({spinner:"none",text:"智 造 云 管 家"}),Object(s.initMenuButtons)({menuId:a,roleId:t}).then(function(t){e.$loading().close();var a=t.buttonList;a&&a.forEach(function(t){e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}))})}).catch(function(t){e.$loading().close()}))},databridge:function(e){this.selectList=e},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},sendGuid:function(e){this.guid=e},searchMap:function(e){this.searchObj=e,this.updateData(this.searchObj)},resetTemp:function(){for(var e in this.temp)this.temp[e]=""},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&this.updateData(this.searchObj)},moneyRetreatByParent:function(e,t){var a=document.body.clientWidth,i=(document.body.clientHeight,.7*a);this.dialogData.dialog_width=i+"px";var o=.666*(.618*i)+"px";this.dialogData.orderDetail_style="height:"+o+";width: 96%;margin-left: 2%;",this.dialogData.data={parentId:e.id,customerId:e.customerId},this.dialogData.title="退款详情",this.openDialogName="dialogMoneyRetreat",this.showDialog=!0,this.visible=!0}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}}),r=(a("r/lH"),a("KHd+")),c=Object(r.a)(l,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"moneyRetreat"},[e.searchList.length?a("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),a("el-row",{staticClass:"tableTopBar"},[a("el-col",[a("div",{staticClass:"tableBtns"},[e._l(e.configs.topBarBtnList,function(e,t){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state},on:{myclick:e.method}})]})],2)])],1),e._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle"},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1)],1)])],1),e._v(" "),e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);c.options.__file="index.vue";t.default=c.exports},QjqE:function(e,t,a){"use strict";a.r(t);a("rGqo"),a("Oyvg");var i=a("WIyV"),o=a("91ra"),n={components:{customBaseTable:i.a},props:["initData","visible"],data:function(){return{parentId:"",customerId:"",openDialogName:"",dialogLoading:!0,isVisible:!1,inDialog:!0,showDialog:!1,inLinVisible:!1,dialogData:{dialog_width:"",orderDetail_style:"",title:"",temp:null,tempLable:null},tableData:[],rowTableList:[],apiObj:{apiName:"listPageRetreatDetailByEdit",params:{pageNo:1,parentId:"",isRetreatByInfo:"true",fieldCode:"sysOrderCode,deliverCode,productCode,productName,productSpec,orderUnitName,receiveAmount,deliverOrderCount,productPrice,orderSum,remark"}},customColumn:[{columnIndex:"orderSum",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"],editable:!0}}],mergeTitle:[],mergeColumn:[],mergeRow:[]}},beforeCreate:function(){},created:function(){this.parentId=this.initData.data.parentId,this.customerId=this.initData.data.customerId,this.apiObj.params.parentId=this.parentId},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(e){this.rowTableList=[],Array.isArray(e)&&(this.rowTableList=e)},isNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(e.trim())},checkColumn:function(e){for(var t="",a=0;a<e.length;a++){var i=e[a],o=i.receiveAmount,n=i.orderSum;o-0==0&&n-o>0?t=t+"第 "+(a+1)+" 行: 退货金额("+n+") 输入错误，退货金额必须等于零！":o-0!=0&&n-o>0&&(t=t+"第 "+(a+1)+" 行: 退货金额("+n+") 输入错误，退货金额不可大于实收金额！")}return t},save:function(){this.$refs.moneyRetreatDialog.getData(),this.saveSaleRetreat(this.rowTableList)},saveSaleRetreat:function(e){var t=this;if(null!=e&&0!=e.length){var a=this.checkColumn(e);if(null!=a&&a.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:a});else{var i=[];e.forEach(function(e){var t={id:e.id,orderSum:e.orderSum,sysOrderCode:e.sysOrderCode,orderId:e.orderId,receiveAmount:e.receiveAmount,notRetreatSum:e.notRetreatSum};i.push(t)});var n="";null!=i&&i.length>0&&(n=JSON.stringify(i)),null!=n&&0!=n?Object(o.updateRetreatByMoney)({parentId:this.parentId,customerId:this.customerId,dtlJsonStr:n}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"暂无发货单明细！"})}}},dialogOpen:function(){},dialogClose:function(e){this.rowTableList=[],this.customerId="",this.deliverDtlIds="",this.$emit("close-dialog",e||{})},closeDialog:function(e){}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}}},s=a("KHd+"),l=Object(s.a)(n,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.initData.dialog_width},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[a("el-row",{style:e.initData.orderDetail_style},[a("custom-base-table",{ref:"moneyRetreatDialog",attrs:{isSortable:!1,varList:e.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,componentId:"moneyRetreatDialog",useDefaultBtn:!1,showAll:!1},on:{databridge:e.databridge}})],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);l.options.__file="dialogMoneyRetreat.vue";t.default=l.exports},"r/lH":function(e,t,a){"use strict";var i=a("8P3P");a.n(i).a}}]);