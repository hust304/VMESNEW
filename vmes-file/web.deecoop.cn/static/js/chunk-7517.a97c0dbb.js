(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-7517"],{Ii92:function(t,e,i){"use strict";var n=i("QUmx");i.n(n).a},QUmx:function(t,e,i){},rG9z:function(t,e,i){"use strict";i.r(e);i("yt8O"),i("RW0V"),i("rGqo");var n=i("uTIz"),o=i("odo6"),a=i("TslA"),s=i("/nWt"),l=i("bI86"),c=i("mSNy"),r=i("V/0Z"),h=i("Vobf"),p=i("z0WU");function g(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},n=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(n=n.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),n.forEach(function(e){f(t,e,i[e])})}return t}function f(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}var d={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n      \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n      \t\t\t\t\t\t\t<el-button  v-show="colConfig.editBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.editBtns(scope.row,scope.$index)">编辑</el-button>\n      \t\t\t\t\t\t\t<el-button  v-show="colConfig.viewBomBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.viewBomBtns(scope.row,scope.$index)">查看BOM</el-button>\n      \t\t\t\t\t\t\t<el-button  v-show="colConfig.listBomBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.listBomBtns(scope.row,scope.$index)">BOM列表</el-button>\n      \t\t\t\t\t</div>\n\n    \t\t\t\t</el-table-column>'},u={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-switch active-value="1" inactive-value="0" v-model="scope.row.isdisable" @change="colConfig.changeState(scope.row,scope.$index)"></el-switch>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},m={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-switch active-value="1" inactive-value="0" v-model="scope.row.isdefault" :disabled=true></el-switch>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},b={data:function(){return{guid:"",searchList:[{label:"货品编码",type:"input",mapKey:"prodCode",configs:{},placeholder:"产品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"prodName",configs:{},placeholder:"产品名称"},{label:"BOM 编码",type:"input",mapKey:"code",configs:{},placeholder:"BOM 编码"},{label:"BOM 名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"BOM 名称"}],searchConfig:{hideSearchSwitch:!1},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:null,tempLable:null},initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",btnName:"编辑",isPropName:!0,component:d,editBtns:this.editBtns,editBtns_isShow:!0,viewBomBtns:this.viewBomBtns,viewBomBtns_isShow:!0,listBomBtns:this.listBomBtns,listBomBtns_isShow:!0}},configs:{topBarBtnList:[{name:"新增",nameEn:"add",isShow:!0,icon:"add",method:this.addNew},{name:"导出",nameEn:"export",isShow:!0,icon:"export",method:this.exportExcel}],tableConfigs:[],showCheckBox:!1,showIndex:!1},tableData:[],selectList:null,temp:{},tempQuery:{},tempLable:{},pageData:null,pageNo:1}},components:{searchBar:n.a,dialogAdd:o.default,dialogEdit:a.default,dialogView:s.default,dialogList:l.default},beforeCreate:function(){},created:function(){this.initButtons(),this.initTable(!0)},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{searchMap:function(t){this.tempQuery=t,this.pageNo=1,this.initTable()},sendGuid:function(t){this.guid=t},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.refreshTable()},initButtons:function(){var t=this;t.$loading({spinner:"preloader",text:""});var e=t.$storage.get("userInfo").roleIds,i=t.$storage.get("menuId");e&&Object(h.initMenuButtons)({menuId:i,roleId:e}).then(function(e){var i=e.buttonList;i&&i.forEach(function(e){if(t.initConfigs&&t.initConfigs.tableOperates)for(var i in t.initConfigs.tableOperates)i.indexOf(e.nameEn)>=0&&i.indexOf("isShow")>0&&(t.initConfigs.tableOperates[i]=!1);if(t.customColumn)for(var n in t.customColumn)if(n){var o=t.customColumn[n];o.length>0&&o.forEach(function(t){if(t)for(var i in t)i.indexOf(e.nameEn)>=0&&i.indexOf("isShow")>0&&(t[i]=!1)})}t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}))})}).catch(function(e){t.$loading().close()})},initTable:function(t){var e=this;Object(r.listPageBoms)(g({},e.tempQuery,{isdefault:"1",modelCode:"Bom",pageNo:e.pageNo})).then(function(i){e.getListPage(i),t&&e.$loading().close()}).catch(function(t){e.$loading().close()})},getListPage:function(t){if(t){this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(p.o)(t.result),i=this.addTableTitle(e);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=t.result.varList,this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})}},initTempData:function(t){var e=this;t.forEach(function(t){for(var i in t){var n=t[i];n.indexOf("_")>0&&("en"==c.a.locale?n=n.substring(n.indexOf("_")+1):"zh"==c.a.locale&&(n=n.substring(0,n.indexOf("_")))),e.tempLable[i]=n}})},addTableTitle:function(t){var e=this;return t.forEach(function(t){var i=t.label;i.indexOf("_")>0&&("en"==c.a.locale?t.label=i.substring(i.indexOf("_")+1):"zh"==c.a.locale&&(t.label=i.substring(0,i.indexOf("_")))),"是否启用"===t.label&&(t.component=u,t.changeState=e.changeState),"是否默认"===t.label&&(t.component=m)}),e.internationalConfig(),t.push(e.initConfigs.tableOperates),t},internationalConfig:function(){"en"==c.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==c.a.locale&&(this.initConfigs.tableOperates.label="操作")},changeState:function(t,e){Object(r.updateDisableBom)(t.id,t.isdisable).then(function(t){}).catch(function(t){})},dataBridge:function(t){this.selectList=t,t.length?this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!1)}):this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})},editBtns:function(t,e){this.resetTemp(),this.temp=JSON.parse(JSON.stringify(t)),this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="编辑",this.openDialogName="dialogEdit",this.showDialog=!0,this.visible=!0},viewBomBtns:function(t,e){this.resetTemp(),this.temp=JSON.parse(JSON.stringify(t)),this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="查看BOM",this.openDialogName="dialogView",this.showDialog=!0,this.visible=!0},listBomBtns:function(t,e){this.resetTemp(),this.temp=JSON.parse(JSON.stringify(t)),this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="BOM列表",this.openDialogName="dialogList",this.showDialog=!0,this.visible=!0},addNew:function(){this.resetTemp(),this.selectList&&this.selectList.length>0&&(this.temp.prodName=this.selectList[0].prodName,this.temp.prodId=this.selectList[0].prodId,this.dialogData.temp=this.temp),this.dialogData.tempLable=this.tempLable,this.dialogData.title="新增",this.openDialogName="dialogAdd",this.showDialog=!0,this.visible=!0},resetTemp:function(){for(var t in this.temp)this.temp[t]=""},refreshTable:function(){var t=this;t.$axios.all([Object(r.listPageBoms)(g({},t.tempQuery,{isdefault:"1",modelCode:"Bom",pageNo:t.pageNo}))]).then(t.$axios.spread(function(e){t.getListPage(e)})).catch(function(t){})},exportExcel:function(){var t="";null!=this.selectList&&this.selectList.length>0&&this.selectList.forEach(function(e){t=t+e.id+","}),Object(r.exportExcelBoms)(t).then(function(t){t&&Object(p.j)(t,"组织管理导出.xls")}).catch(function(t){})}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){this.initTable()}}},B=(i("Ii92"),i("KHd+")),w=Object(B.a)(b,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"equipmentManage"},[t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[i("el-col",{staticClass:"tableStyle",attrs:{span:24}},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2)])],1),t._v(" "),i("el-row",{staticClass:"tableContent"},[i("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,pageData:t.pageData,currentpage:t.pageNo},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1)],1)])],1),t._v(" "),t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);w.options.__file="index_bak.vue";e.default=w.exports}}]);