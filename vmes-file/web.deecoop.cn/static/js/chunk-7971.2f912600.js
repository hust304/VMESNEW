(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-7971"],{"6w3G":function(t,e,a){},C3M2:function(t,e,a){},IZi7:function(t,e,a){"use strict";a.r(e);a("rGqo"),a("yt8O"),a("XfO3"),a("9AAn");var n=a("2+ib"),o=a("uTIz"),i=a("QjqE"),s=(a("+bMf"),a("Vobf")),l=(a("z0WU"),{components:{multilevelTable:n.a,searchBar:o.a,dialogMoneyRetreat:i.default},data:function(){return{retreatStateNameMap:new Map([["0","待提交"],["1","待审核"],["2","待退款"],["3","已完成"],["-1","已取消"]]),searchList:[{label:"退货编号",type:"input",ruleType:"string",mapKey:"sysCode",configs:{},placeholder:"退货编号"},{label:"客户名称",type:"input",ruleType:"string",mapKey:"customerName",configs:{},placeholder:"客户名称"},{label:"退货单状态",type:"select",ruleType:"string",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"0",label:"待提交"},{value:"1",label:"待审核"},{value:"3",label:"已完成"},{value:"-1",label:"已取消"}]},placeholder:"请选择"},{label:"制单日期起",type:"date",ruleType:"date",mapKey:"cdateBegin",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"},{label:"制单日期止",type:"date",ruleType:"date",mapKey:"cdateEnd",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"}],guid:"",tableConfigList:[{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},default:{state:"0",text:"待提交"},info1:{state:"1",text:"待审核"},info2:{state:"2",text:"待退款"},info:{state:"-1",text:"已取消"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"退款",nameEn:"moneyRetreatByParent",editBtns_isShow:!0,icon:"moneyRetreatByParent",method:this.moneyRetreatByParent}]}],apiObj:{apiName:"listPageSaleRetreat",params:{dataType:this.$storage.get("dataType"),state:"2"}},tempData:{},showHeader:!0,showIndex:!0,showCheckBox:!0,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},default:{state:"0",text:"待提交"},info1:{state:"1",text:"待审核"},info2:{state:"2",text:"待退款"},info:{state:"-1",text:"已取消"}}}],apiObj:{apiName:"listPageSaleRetreatDetail",params:{}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!1,isSingle:!1,componentId:"twoLevelTable"}],searchObj:{},selectList:[],configs:{topBarBtnList:[],tableConfigs:[],showCheckBox:!1},openDialogName:"",showDialog:!1,visible:!1,dialogData:{dialog_width:"",orderDetail_style:"",title:"",data:{},tempLable:null},tableData:[],rowTableList:[]}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var t=this,e=t.$storage.get("userInfo").roleIds,a=t.$storage.get("menuId");e&&(t.$loading({spinner:"preloader",text:""}),Object(s.initMenuButtons)({menuId:a,roleId:e}).then(function(e){t.$loading().close();var a=e.buttonList;a&&a.forEach(function(e){t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)})),t.tableConfigList&&t.tableConfigList.forEach(function(t){t.customColumn&&t.customColumn.forEach(function(t){"last"==t.columnIndex&&t.component&&t.component.forEach(function(t){t.nameEn==e.nameEn&&(t.rowState="1==2")})})})})}).catch(function(e){t.$loading().close()}))},databridge:function(t){this.selectList=t},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(t,e){this.$refs.customBaseTable.pushData(t,e)},updateData:function(t){this.$refs.customBaseTable.updateData(t)},deleteData:function(t){this.$refs.customBaseTable.deleteData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.updateData(this.searchObj)},resetTemp:function(){for(var t in this.temp)this.temp[t]=""},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.updateData(this.searchObj)},moneyRetreatByParent:function(t,e){var a=document.body.clientWidth,n=(document.body.clientHeight,.7*a);this.dialogData.dialog_width=n+"px";var o=.666*(.618*n)+"px";this.dialogData.orderDetail_style="height:"+o+";width: 96%;margin-left: 2%;",this.dialogData.data={parentId:t.id,customerId:t.customerId},this.dialogData.title="退款详情",this.openDialogName="dialogMoneyRetreat",this.showDialog=!0,this.visible=!0}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}}),r=(a("r/lH"),a("Q5t1"),a("KHd+")),c=Object(r.a)(l,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"moneyRetreat"},[t.searchList.length?a("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),a("el-row",{staticClass:"tableTopBar"},[a("el-col",[a("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2)])],1),t._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle"},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_sale_retreat_moneyRetreat_index0",tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1)],1)])],1),t._v(" "),t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);c.options.__file="index.vue";e.default=c.exports},Q5t1:function(t,e,a){"use strict";var n=a("6w3G");a.n(n).a},"r/lH":function(t,e,a){"use strict";var n=a("C3M2");a.n(n).a}}]);