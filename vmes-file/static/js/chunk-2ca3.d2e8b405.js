(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-2ca3","chunk-4918"],{O9pe:function(t,e,i){},QHJy:function(t,e,i){"use strict";var n=i("O9pe");i.n(n).a},SoRP:function(t,e,i){},XxF7:function(t,e,i){"use strict";i.r(e);i("yt8O"),i("RW0V"),i("rGqo");var n=i("uTIz"),o=i("lDFo"),a=i("mSNy"),s=i("9rC1"),l=(i("5W5M"),i("Vobf")),c=i("z0WU");function r(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},n=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(n=n.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),n.forEach(function(e){u(t,e,i[e])})}return t}function u(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}var f={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n      \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n      \t\t\t\t\t\t\t<el-button v-show="colConfig.setAccountDays_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.setAccountDays(scope.row,scope.$index)">设置账期</el-button>\n      \t\t\t\t\t\t\t\x3c!--<el-button v-show="colConfig.addressList_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.addressList(scope.row,scope.$index)">详细地址</el-button>--\x3e\n      \t\t\t\t\t\t\t\x3c!--<el-button  v-show="colConfig.qrcodeBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.qrcodeBtns(scope.row,scope.$index)">二维码</el-button>--\x3e\n      \t\t\t\t\t</div>\n\n    \t\t\t\t</el-table-column>'},p={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-switch active-value="1" inactive-value="0" v-model="scope.row.isdisable" @change="colConfig.changeState(scope.row,scope.$index)"></el-switch>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},g={data:function(){return{guid:"",searchList:[{label:"客户编码",type:"input",mapKey:"code",configs:{},placeholder:"请输入客户编码"},{label:"客户名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"请输入客户名称"}],searchConfig:{hideSearchSwitch:!1},openDialogName:"",showDialog:!1,visible:!1,dialogData:{width:400,title:"",temp:null,tempLable:null},initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",btnName:"编辑",isPropName:!0,component:f,setAccountDays:this.setAccountDays,setAccountDays_isShow:!0}},configs:{topBarBtnList:[],tableConfigs:[],showCheckBox:!1,showIndex:!1},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},tableData:[],selectList:null,temp:{},tempQuery:{},tempLable:{},pageData:null,pageNo:1}},components:{searchBar:n.a,dialogAccountDays:o.default},beforeCreate:function(){},created:function(){this.initButtons(),this.initTable(!0)},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{searchMap:function(t){this.tempQuery=t,this.initTable(null)},sendGuid:function(t){this.guid=t},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.refreshTable()},initButtons:function(){var t=this,e=t.$storage.get("userInfo").roleIds,i=t.$storage.get("menuId");e&&(t.$loading({spinner:"none",text:"智 造 云 管 家"}),Object(l.initMenuButtons)({menuId:i,roleId:e}).then(function(e){var i=e.buttonList;i&&i.forEach(function(e){if(t.initConfigs&&t.initConfigs.tableOperates)for(var i in t.initConfigs.tableOperates)i.indexOf(e.nameEn)>=0&&i.indexOf("isShow")>0&&(t.initConfigs.tableOperates[i]=!1);if(t.customColumn)for(var n in t.customColumn)if(n){var o=t.customColumn[n];o.length>0&&o.forEach(function(t){if(t)for(var i in t)i.indexOf(e.nameEn)>=0&&i.indexOf("isShow")>0&&(t[i]=!1)})}t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(console.log(t),t.isShow=!1)}))})}).catch(function(e){console.log(e),t.$loading().close()}))},initTable:function(t){var e=this;Object(s.listPageCustomerAccountDays)(r({},e.tempQuery,{genre:"df7cb67fca4148bc9632c908e4a7fdea",pageNo:e.pageNo})).then(function(i){e.getListPage(i),t&&e.$loading().close()}).catch(function(t){e.$loading().close()})},getListPage:function(t){if(t){this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(c.m)(t.result),i=this.addTableTitle(e);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=t.result.varList,this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})}},initTempData:function(t){var e=this;t.forEach(function(t){for(var i in t){var n=t[i];n.indexOf("_")>0&&("en"==a.a.locale?n=n.substring(n.indexOf("_")+1):"zh"==a.a.locale&&(n=n.substring(0,n.indexOf("_")))),e.tempLable[i]=n}}),console.log(e.tempLable)},addTableTitle:function(t){var e=this;return t.forEach(function(t){var i=t.label;i.indexOf("_")>0&&("en"==a.a.locale?t.label=i.substring(i.indexOf("_")+1):"zh"==a.a.locale&&(t.label=i.substring(0,i.indexOf("_")))),"是否启用"===t.label&&(t.component=p,t.changeState=e.changeState)}),e.internationalConfig(),t.push(e.initConfigs.tableOperates),t},internationalConfig:function(){"en"==a.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==a.a.locale&&(this.initConfigs.tableOperates.label="操作")},dataBridge:function(t){this.selectList=t,t.length?this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!1)}):this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})},setAccountDays:function(t,e){this.resetTemp(),this.temp=JSON.parse(JSON.stringify(t)),this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="设置账期",this.openDialogName="dialogAccountDays",this.showDialog=!0,this.visible=!0},resetTemp:function(){for(var t in this.temp)this.temp[t]=""},refreshTable:function(){var t=this;t.$axios.all([Object(s.listPageCustomerAccountDays)(r({},t.tempQuery,{genre:"df7cb67fca4148bc9632c908e4a7fdea",pageNo:t.pageNo}))]).then(t.$axios.spread(function(e){t.getListPage(e)})).catch(function(t){console.log(t)})}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){this.initTable(null,this.selectTree.id)}}},h=(i("QHJy"),i("KHd+")),d=Object(h.a)(g,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"customerManage"},[t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[i("el-col",{staticClass:"tableStyle",attrs:{span:24}},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2)])],1),t._v(" "),i("el-row",{staticClass:"tableContent"},[i("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,pageData:t.pageData,currentpage:t.pageNo},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1)],1)])],1),t._v(" "),t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);d.options.__file="index.vue";e.default=d.exports},aiLm:function(t,e,i){"use strict";var n=i("SoRP");i.n(n).a},lDFo:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf");var n=i("9rC1");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var a={name:"dialog-edit",props:["initData","visible"],data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{}}},created:function(){this.initData.temp&&(this.temp=this.initData.temp),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},save:function(){var t=this;t.$refs.submitForm.validate(function(e){e&&(t.dialogLoading=!0,Object(n.updateCustomer)(t.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"修改成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1}))})}}},s=(i("aiLm"),i("KHd+")),l=Object(s.a)(a,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:t.dialogWidth},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"90%",margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-form-item",{attrs:{label:t.tempLable.accountType+":",prop:"accountType"}},[i("el-radio",{attrs:{label:"0"},model:{value:t.temp.accountType,callback:function(e){t.$set(t.temp,"accountType",e)},expression:"temp.accountType"}},[t._v("从发货日期开始计算")])],1),t._v(" "),i("el-form-item",{attrs:{label:t.tempLable.accountDays+":",prop:"accountDays"}},[i("el-input",{model:{value:t.temp.accountDays,callback:function(e){t.$set(t.temp,"accountDays",e)},expression:"temp.accountDays"}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)])},[],!1,null,"4764b8c5",null);l.options.__file="dialogAccountDays.vue";e.default=l.exports}}]);