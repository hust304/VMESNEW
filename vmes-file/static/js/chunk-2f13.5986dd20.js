(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-2f13","chunk-2d02","chunk-2d05"],{"0UOL":function(t,e,i){"use strict";i.r(e);i("yt8O"),i("RW0V"),i("rGqo");var a=i("mSNy"),o=i("aZSg"),n=i("e+LY"),s=i("m0qk"),l=i("z0WU");function r(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),a.forEach(function(e){c(t,e,i[e])})}return t}function c(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}var u={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-switch active-value="1" inactive-value="0" v-model="scope.row.isdisable" @change="colConfig.changeState(scope.row,scope.$index)"></el-switch>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},d={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n      \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n      \t\t\t\t\t\t\t<el-button v-show="colConfig.editBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.editBtns(scope.row,scope.$index)">设置价格</el-button>\n      \t\t\t\t\t\t\t<el-button v-show="colConfig.listBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.listBtns(scope.row,scope.$index)">查看历史价格</el-button>\n      \t\t\t\t\t</div>\n\n    \t\t\t\t</el-table-column>'},p={name:"dialog-option",props:["initData","visible"],data:function(){return{dialogTopLoading:!1,isVisible:!1,title:"",userInfo:null,topBarBtnList:[{name:"查询",icon:"search",method:this.queryTable},{name:"重置",icon:"refresh",plain:!0,method:this.resetQueryTemp}],initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",btnName:"编辑",isPropName:!0,component:d,editBtns:this.editBtns,editBtns_isShow:!0,listBtns:this.listBtns,listBtns_isShow:!0}},configs:{topBarBtnList:[],tableConfigs:[],showCheckBox:!1,showIndex:!1,isSingle:!1},tableData:[],selectList:[],queryParms:[{name:"code"},{name:"name"}],temp:{},tempQuery:{},tempLable:{},pageData:null,pageNo:1,openDialogName:"",showDialog:!1,visibleState:!1,dialogData:{title:"",temp:null,tempLable:null}}},components:{dialogCustomerPriceEdit:n.default,dialogCustomerPriceList:s.default},beforeCreate:function(){},created:function(){this.title=this.initData.title,this.configs.isSingle=this.initData.isSingle,this.userInfo=this.$storage.get("userInfo"),this.initTable(!0)},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{editBtns:function(t,e){this.temp=JSON.parse(JSON.stringify(t)),this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="编辑",this.openDialogName="dialogCustomerPriceEdit",this.showDialog=!0,this.visibleState=!0},listBtns:function(t,e){this.dialogData.productId=t.productId,this.dialogData.title="货品历史价格",this.openDialogName="dialogCustomerPriceList",this.showDialog=!0,this.visibleState=!0},dialogClose:function(){this.$emit("close-dialog",{resState:"ok"})},queryTable:function(){this.pageNo=1,this.initTable(!0)},initTable:function(t){var e=this;e.dialogTopLoading=!0,Object(o.b)(r({},e.tempQuery,{productId:this.initData.temp.productId,customerId:this.initData.temp.customerId,pageNo:e.pageNo})).then(function(i){e.getListPage(i),t&&(e.dialogTopLoading=!1)}).catch(function(t){e.dialogTopLoading=!1})},getListPage:function(t){if(t){this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(l.j)(t.result),i=this.addTableTitle(e);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=t.result.varList}},initTempData:function(t){var e=this;t.forEach(function(t){for(var i in t){var o=t[i];o.indexOf("_")>0&&("en"==a.a.locale?o=o.substring(o.indexOf("_")+1):"zh"==a.a.locale&&(o=o.substring(0,o.indexOf("_")))),e.tempLable[i]=o}})},addTableTitle:function(t){var e=this;return t.forEach(function(t){var i=t.label;i.indexOf("_")>0&&("en"==a.a.locale?t.label=i.substring(i.indexOf("_")+1):"zh"==a.a.locale&&(t.label=i.substring(0,i.indexOf("_")))),"是否启用"===t.label&&(t.component=u,t.changeState=e.changeState),"是否默认"===t.label&&(t.component=isdefaultBtns,t.changeIsDefault=e.changeIsDefault)}),t.push(e.initConfigs.tableOperates),t},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.refreshTable()},refreshTable:function(){var t=this;t.$axios.all([Object(o.b)(r({},t.tempQuery,{productId:this.initData.temp.productId,customerId:this.initData.temp.customerId,pageNo:t.pageNo}))]).then(t.$axios.spread(function(e){t.getListPage(e)})).catch(function(t){})},dataBridge:function(t){this.selectList=t},resetQueryTemp:function(){for(var t in this.tempQuery)this.tempQuery[t]=""}},computed:{dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){this.initTable()}}},g=i("KHd+"),f=Object(g.a)(p,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.title,visible:t.isVisible,"append-to-body":"",width:"1300px"},on:{"update:visible":function(e){t.isVisible=e},close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visibleState},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogTopLoading,expression:"dialogTopLoading"}],staticStyle:{height:"500px"}},[i("el-col",{staticStyle:{height:"100%"},attrs:{span:24}},[i("div",{staticStyle:{height:"calc(100% - 60px)","box-sizing":"border-box",padding:"7px"}},[i("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,isSingle:t.configs.isSingle,isSortable:!1,pageData:t.pageData,currentpage:t.pageNo},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1),t._v(" "),i("div",{staticStyle:{"text-align":"center","padding-bottom":"10px"}},[i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)])],1)],1)},[],!1,null,null,null);f.options.__file="dialogCustomerPrice.vue";e.default=f.exports},aZSg:function(t,e,i){"use strict";i.d(e,"d",function(){return o}),i.d(e,"b",function(){return n}),i.d(e,"e",function(){return s}),i.d(e,"c",function(){return l}),i.d(e,"a",function(){return r});var a=i("t3Un");function o(t){return Object(a.a)({url:"/sale/saleUnitPrice/listPageSaleUnitPrices",method:"post",data:t})}function n(t){return Object(a.a)({url:"/sale/saleUnitPrice/listPageCustomerUnitPrices",method:"post",data:t})}function s(t){return Object(a.a)({url:"/sale/saleUnitPrice/update",method:"post",data:t})}function l(t){return Object(a.a)({url:"/sale/saleUnitPrice/listPageCustomerUnitPricesHis",method:"post",data:t})}function r(t){return Object(a.a)({url:"/sale/saleUnitPrice/findSaleUnitPrice",method:"post",data:t})}},"e+LY":function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf"),i("Oyvg");var a=i("aZSg");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={components:{},name:"dialog-edit",props:["initData","visible"],data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{}}},created:function(){this.initData.temp&&(this.temp=this.initData.temp)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{dialogOpen:function(){},dialogClose:function(t){this.$emit("close-dialog",t||{})},checkPrice:function(t){new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(t)||this.$message({message:"单价:"+t+" 输入错误，请输入大于零的正整数或(1,2)位小数！",type:"warning",duration:5e3})},save:function(){var t=this;this.$refs.submitForm.validate(function(e){e&&(t.dialogLoading=!0,Object(a.e)({id:t.temp.id,productPrice:t.temp.customerPrice}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1}))})}}},s=i("KHd+"),l=Object(s.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"570px",margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-form-item",{attrs:{label:"标准价:",prop:"productPrice"}},[i("el-input",{staticStyle:{width:"240px"},attrs:{disabled:!0},model:{value:t.temp.productPrice,callback:function(e){t.$set(t.temp,"productPrice",e)},expression:"temp.productPrice"}})],1),t._v(" "),i("el-form-item",{attrs:{label:"专属价:",prop:"customerPrice"}},[i("el-input",{staticStyle:{width:"240px"},on:{change:t.checkPrice},model:{value:t.temp.customerPrice,callback:function(e){t.$set(t.temp,"customerPrice",t._n(e))},expression:"temp.customerPrice"}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)])},[],!1,null,null,null);l.options.__file="dialogCustomerPriceEdit.vue";e.default=l.exports},m0qk:function(t,e,i){"use strict";i.r(e);i("yt8O"),i("RW0V"),i("rGqo");var a=i("mSNy"),o=i("aZSg"),n=i("z0WU");function s(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),a.forEach(function(e){l(t,e,i[e])})}return t}function l(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}var r={name:"dialog-option",props:["initData","visible"],data:function(){return{productId:"",dialogTopLoading:!1,isVisible:!1,title:"",topBarBtnList:[{name:"查询",icon:"search",method:this.queryTable},{name:"重置",icon:"refresh",plain:!0,method:this.resetQueryTemp}],initConfigs:{tableOperates:{}},configs:{topBarBtnList:[],tableConfigs:[],showCheckBox:!1,showIndex:!1,isSingle:!1},tableData:[],selectList:[],queryParms:[],temp:{},tempQuery:{},tempLable:{},pageData:null,pageNo:1,openDialogName:"",showDialog:!1,visibleState:!1,dialogData:{title:"",temp:null,tempLable:null}}},components:{},beforeCreate:function(){},created:function(){this.title=this.initData.title,this.productId=this.initData.productId,this.initTable(!0)},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{dialogClose:function(){this.$emit("close-dialog",{resState:"ok"})},queryTable:function(){this.pageNo=1,this.initTable(!0)},initTable:function(t){var e=this;e.dialogTopLoading=!0,Object(o.c)(s({},e.tempQuery,{productId:this.initData.productId,customerId:this.initData.customerId,unit:this.initData.unit,pageNo:e.pageNo})).then(function(i){e.getListPage(i),t&&(e.dialogTopLoading=!1)}).catch(function(t){e.dialogTopLoading=!1})},getListPage:function(t){if(t){this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(n.j)(t.result),i=this.addTableTitle(e);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=t.result.varList}},initTempData:function(t){var e=this;t.forEach(function(t){for(var i in t){var o=t[i];o.indexOf("_")>0&&("en"==a.a.locale?o=o.substring(o.indexOf("_")+1):"zh"==a.a.locale&&(o=o.substring(0,o.indexOf("_")))),e.tempLable[i]=o}})},addTableTitle:function(t){return t.forEach(function(t){var e=t.label;e.indexOf("_")>0&&("en"==a.a.locale?t.label=e.substring(e.indexOf("_")+1):"zh"==a.a.locale&&(t.label=e.substring(0,e.indexOf("_"))))}),t},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.refreshTable()},refreshTable:function(){var t=this;t.$axios.all([Object(o.c)(s({},t.tempQuery,{productId:this.initData.productId,customerId:this.initData.customerId,unit:this.initData.unit,pageNo:t.pageNo}))]).then(t.$axios.spread(function(e){t.getListPage(e)})).catch(function(t){})},dataBridge:function(t){this.selectList=t},resetQueryTemp:function(){for(var t in this.tempQuery)this.tempQuery[t]=""}},computed:{dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){this.initTable()}}},c=i("KHd+"),u=Object(c.a)(r,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.title,visible:t.isVisible,"append-to-body":"",width:"1300px"},on:{"update:visible":function(e){t.isVisible=e},close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visibleState},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogTopLoading,expression:"dialogTopLoading"}],staticStyle:{height:"500px"}},[i("el-col",{staticStyle:{height:"100%"},attrs:{span:24}},[i("div",{staticStyle:{height:"calc(100% - 60px)","box-sizing":"border-box",padding:"7px"}},[i("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,isSingle:t.configs.isSingle,isSortable:!1,pageData:t.pageData,currentpage:t.pageNo},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1),t._v(" "),i("div",{staticStyle:{"text-align":"center","padding-bottom":"10px"}},[i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)])],1)],1)},[],!1,null,null,null);u.options.__file="dialogCustomerPriceList.vue";e.default=u.exports}}]);