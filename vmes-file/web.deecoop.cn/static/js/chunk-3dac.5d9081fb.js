(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-3dac"],{"2I+1":function(e,t,i){"use strict";var n=i("OcOR");i.n(n).a},OcOR:function(e,t,i){},ZPgF:function(e,t,i){"use strict";i.r(t);i("91GP");var n=i("rdjU"),a=i("nG85"),o=i("uTIz"),s=i("asQK"),l=i("c5eW"),c={data:function(){return{fieldCode:"code,name,typeName,amount,invoiceCode,userName,cdate,state",openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:null,tempLable:null},searchList:[{label:"单据编号",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"请输入单据编号"},{label:"客户名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"请输入客户名称"},{label:"企业名称",type:"input",ruleType:"string",mapKey:"companyName",configs:{},placeholder:"请输入企业名称"},{label:"发票税号",type:"input",ruleType:"string",mapKey:"invoiceNumber",configs:{},placeholder:"请输入发票税号"}],searchMethod:{},searchConfig:{},guid:"",searchObj:{},activeName:0,tabs:[{label:"待开票",btns:[{btnName:"申请开票",method:this.invoice,disabled:!1}],componentName:"baseTable",tableConfigList:[{customColumn:[{columnIndex:"code",width:"90",_cellConfig:{hideTitle:!0}},{columnIndex:"name",width:"250",_cellConfig:{hideTitle:!0}},{columnIndex:"typeName",width:"100",_cellConfig:{hideTitle:!0}},{columnIndex:"invoiceCode",width:"100",_cellConfig:{hideTitle:!0}},{columnIndex:"cdate",width:"90",_cellConfig:{hideTitle:!0}},{columnIndex:"state",width:"80",componentName:"tag",_cellConfig:{success:{state:"1",text:"已开票"},warning:{state:"-1",text:"已退票"},default:{state:"0",text:"待开票"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",width:"100",component:[{name:"详情",editBtns_isShow:!0,icon:"view",method:this.viewInvoice},{name:"删除",editBtns_isShow:!0,icon:"delete",method:this.deleteRow}]}],mergeTitle:[],apiObj:{apiName:"listPageFinanceInvoices",params:{fieldCode:"",state:"0",orderStr:"code desc"}},showIndex:!1,showCheckBox:!1,showTableSet:!1,expand:!1,expandMode:"none"}]},{label:"已开票",componentName:"baseTable",tableConfigList:[{customColumn:[{columnIndex:"code",width:"90",_cellConfig:{hideTitle:!0}},{columnIndex:"name",width:"250",_cellConfig:{hideTitle:!0}},{columnIndex:"typeName",width:"100",_cellConfig:{hideTitle:!0}},{columnIndex:"invoiceCode",width:"100",_cellConfig:{hideTitle:!0}},{columnIndex:"cdate",width:"90",_cellConfig:{hideTitle:!0}},{columnIndex:"state",width:"80",componentName:"tag",_cellConfig:{success:{state:"1",text:"已开票"},warning:{state:"-1",text:"已退票"},default:{state:"0",text:"待开票"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",width:"100",component:[{name:"详情",editBtns_isShow:!0,icon:"view",method:this.viewInvoice}]}],mergeTitle:[],apiObj:{apiName:"listPageFinanceInvoices",params:{fieldCode:"",state:"1",orderStr:"code desc"}},showIndex:!1,showCheckBox:!1,showTableSet:!1,expand:!1,expandMode:"none"}]},{label:"已退票",btns:[],componentName:"baseTable",tableConfigList:[{customColumn:[{columnIndex:"code",width:"90",_cellConfig:{hideTitle:!0}},{columnIndex:"name",width:"250",_cellConfig:{hideTitle:!0}},{columnIndex:"typeName",width:"100",_cellConfig:{hideTitle:!0}},{columnIndex:"invoiceCode",width:"100",_cellConfig:{hideTitle:!0}},{columnIndex:"cdate",width:"90",_cellConfig:{hideTitle:!0}},{columnIndex:"state",width:"80",componentName:"tag",_cellConfig:{success:{state:"1",text:"已开票"},warning:{state:"-1",text:"已退票"},default:{state:"0",text:"待开票"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",width:"100",component:[{name:"详情",editBtns_isShow:!0,icon:"view",method:this.viewInvoice}]}],mergeTitle:[],apiObj:{apiName:"listPageFinanceInvoices",params:{fieldCode:"",state:"-1",orderStr:"code desc"}},showIndex:!1,showCheckBox:!1,showTableSet:!1,expand:!1,expandMode:"none"}]}]}},components:{dialogFinanceInvoice:n.default,dialogViewCustomerInvoice:a.default,searchBar:o.a,multiLabelTable:s.a},created:function(){this.tabs[0].tableConfigList[0].apiObj.params.fieldCode=this.fieldCode,this.tabs[1].tableConfigList[0].apiObj.params.fieldCode=this.fieldCode,this.tabs[2].tableConfigList[0].apiObj.params.fieldCode=this.fieldCode},mounted:function(){},methods:{sendTabsKey:function(e){this.activeName=e},databridge:function(e){},sendGuid:function(e){this.guid=e},refresh:function(){this.activeName>-1&&(this.tabs[this.activeName].tableConfigList[0].apiObj.params=Object.assign({},this.tabs[this.activeName].tableConfigList[0].apiObj.params,this.searchObj))},searchMap:function(e){this.searchObj=e,this.activeName>-1&&(this.tabs[this.activeName].tableConfigList[0].apiObj.params=Object.assign({},this.tabs[this.activeName].tableConfigList[0].apiObj.params,this.searchObj))},rebackInvoice:function(e,t,i){var n=this;this.$loading({spinner:"preloader",text:""}),Object(l.rebackFinanceInvoice)(e).then(function(e){n.$loading().close(),0===e.code&&(n.$notify({title:"成功",message:"开票成功",type:"success",duration:2e3}),n.refresh())}).catch(function(e){n.$loading().close()})},openInvoice:function(e,t,i){var n=this;this.$loading({spinner:"preloader",text:""}),Object(l.openFinanceInvoice)(e).then(function(e){n.$loading().close(),0===e.code&&(n.$notify({title:"成功",message:"开票成功",type:"success",duration:2e3}),n.refresh())}).catch(function(e){n.$loading().close()})},deleteRow:function(e,t,i){var n=this;this.$loading({spinner:"preloader",text:""}),Object(l.deleteFinanceInvoice)(e).then(function(e){n.$loading().close(),0===e.code&&(n.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),n.refresh())}).catch(function(e){n.$loading().close()})},viewInvoice:function(e,t,i){this.dialogData.temp=JSON.parse(JSON.stringify(e)),this.dialogData.title="查看发票信息",this.openDialogName="dialogViewCustomerInvoice",this.showDialog=!0,this.visible=!0},closeDialog:function(e){this.visible=!1,this.showDialog=!1,"ok"==e.resState&&this.refresh()},invoice:function(e){this.dialogData.title="选择客户",this.openDialogName="dialogFinanceInvoice",this.showDialog=!0,this.visible=!0},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}}},d=(i("2I+1"),i("KHd+")),h=Object(d.a)(c,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"saleInvoice"},[e.searchList.length?i("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),i("el-row",{staticStyle:{"border-bottom":"none",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[i("multi-label-table",{attrs:{tabs:e.tabs},on:{tabsKey:e.sendTabsKey,databridge:e.databridge,callmethod:e.callMethod}})],1),e._v(" "),e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);h.options.__file="index.vue";t.default=h.exports}}]);