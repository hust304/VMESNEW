(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-616d","Sy3O"],{"78mO":function(t,e,i){},"9WTv":function(t,e,i){"use strict";i.d(e,"d",function(){return a}),i.d(e,"a",function(){return o}),i.d(e,"f",function(){return s}),i.d(e,"e",function(){return l}),i.d(e,"b",function(){return r}),i.d(e,"c",function(){return c});var n=i("t3Un");function a(t){return Object(n.a)({url:"/equipment/listPageEquipments",method:"post",data:t})}function o(t){return Object(n.a)({url:"/equipment/addEquipment",method:"post",data:t})}function s(t){return Object(n.a)({url:"/equipment/updateEquipment",method:"post",data:t})}function l(t,e){return Object(n.a)({url:"/equipment/update",method:"post",data:{id:t,isdisable:e}})}function r(t){return Object(n.a)({url:"/equipment/deleteByIds",method:"post",data:{ids:t}})}function c(t){return Object(n.a)({url:"/equipment/exportExcelEquipments",method:"post",responseType:"blob",data:{ids:t}})}},HWi0:function(t,e,i){"use strict";i.r(e);i("91GP"),i("rGqo");var n=i("zDZ1"),a=i("lX1r"),o=i("uTIz"),s=i("Sy3O"),l=i("8Vv6"),r=(i("rwyD"),i("Vobf"));i("z0WU");function c(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}var d={props:["colConfig"],template:'<el-table-column :label="colConfig.label" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t    \x3c!--<el-button v-show="colConfig.infoByParent_isShow" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.infoByParent(scope.row,scope.$index)">详情</el-button>--\x3e\n    \t\t\t\t\t    <el-button v-show="colConfig.editByParent_isShow && scope.row.state == \'0\'" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.editByParent(scope.row,scope.$index)">编辑</el-button>\n    \t\t\t\t\t    <el-button v-show="colConfig.deleteByParent_isShow && (scope.row.state == \'0\' || scope.row.state == \'-1\')" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.deleteByParent(scope.row,scope.$index)">删除</el-button>\n    \t\t\t\t\t\t\t<el-button v-show="colConfig.cancelByParent_isShow && scope.row.state == \'0\'" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.cancelByParent(scope.row,scope.$index,scope)">取消</el-button>\n    \t\t\t\t\t\t\t\x3c!--<el-button v-show="colConfig.recoveryByParent_isShow && scope.row.state == \'-1\'" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.recoveryByParent(scope.row,scope.$index,scope)">恢复</el-button>--\x3e\n    \t\t\t\t\t</div>\n  \t\t\t\t</el-table-column>'},u={components:{dialogQrcode:n.a,expandTable:a.a,searchBar:o.a,dialogOrderDetail:s.default},data:function(){var t;return c(t={colConfigs:[],initData:{},childrenDialogTitleList:[],fromTemp:{},showDialog:!1,dialogVisible:!1,dialogCallBackData:null,baseLayer:0,searchList:[{label:"订单编号",type:"input",ruleType:"string",mapKey:"sysCode",configs:{},placeholder:"订单编号"}],guid:"",currentpage:1,maxLayer:2,expandTableApiList:["listPageSaleOrder","listPageSaleOrderDetail"],expandTableApiParams:[{isNeedDeliver:"true"},{parentId:""}],initParams:{},updateViewData:{},searchObj:{},titleList:[],pageData:{},childrenData:{},customColumn:{1:[{columnIndex:"last",prop:"operate",label:"操作",component:d,editByParent:this.editByParent,editByParent_isShow:!0,cancelByParent:this.cancelByParent,cancelByParent_isShow:!0,deleteByParent:this.deleteByParent,deleteByParent_isShow:!0}]},tableSets:{1:{showCheckBox:!1,showIndex:!0,expandOne:!1},2:{showCheckBox:!0,showIndex:!1,isExpands:!1,isSortable:!1,isSingle:!1}},configs:{topBarBtnList:[{name:"生成发货单",nameEn:"add",isShow:!0,icon:"add",method:this.dialogAdd}],tableConfigs:[],showCheckBox:!1},temp:{},openDialogName:""},"showDialog",!1),c(t,"visible",!1),c(t,"dialogData",{title:"",orderDtlIds:"",tempLable:null}),t},beforeCreate:function(){},created:function(){this.initButtons(),this.initExpandTable()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var t=this;t.$loading({spinner:"none",text:"智 造 云 管 家"});var e=t.$storage.get("userInfo").roleIds,i=t.$storage.get("menuId");e&&Object(r.initMenuButtons)({menuId:i,roleId:e}).then(function(e){var i=e.buttonList;i&&i.forEach(function(e){if(t.initConfigs&&t.initConfigs.tableOperates)for(var i in t.initConfigs.tableOperates)i.indexOf(e.nameEn)>=0&&i.indexOf("isShow")>0&&(t.initConfigs.tableOperates[i]=!1);if(t.customColumn)for(var n in t.customColumn)if(n){var a=t.customColumn[n];a.length>0&&a.forEach(function(t){if(t)for(var i in t)i.indexOf(e.nameEn)>=0&&i.indexOf("isShow")>0&&(t[i]=!1)})}t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}))})}).catch(function(e){t.$loading().close()})},initExpandTable:function(){var t=this;this.$api[this.expandTableApiList[0]](this.setParams(1,this.expandTableApiParams[0],this.currentpage)).then(function(e){t.initData={row:null,layer:1,res:e,customColumn:t.customColumn},t.$loading().close()}).catch(function(e){t.$loading().close()})},databridge:function(t){this.temp.dataList=t},findChildByRow:function(t,e,i,n,a){var o=this;this.$api[this.expandTableApiList[e-1]](this.setParams(e,t,a)).then(function(i){o.childrenData={row:t,layer:e,res:i,customColumn:o.customColumn}}).catch(function(t){})},setParams:function(t,e,i){var n=Object.assign({},this.expandTableApiParams[t-1]);for(var a in n)n.hasOwnProperty(a)&&!n[a]&&(n[a]=e[a]||"");return Object.assign({},n,this.searchObj,{pageNo:i})},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.initExpandTable()},resetTemp:function(){for(var t in this.temp)this.temp[t]=""},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.initExpandTable()},dialogAdd:function(){var t=this.temp.dataList;if(null!=t&&0!=t.length){var e="";t.forEach(function(t){e=e+t.id.trim()+","}),this.dialogData.title="生成发货单",this.dialogData.orderDtlIds=e,this.openDialogName="dialogOrderDetail",this.showDialog=!0,this.visible=!0}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条订单明细！"})},editByParent:function(t,e){this.$storage.get("userInfo").userId==t.makeId?(this.resetTemp(),this.dialogData.temp=t,this.dialogData.title="编辑订单",this.openDialogName="dialogEdit",this.showDialog=!0,this.visible=!0):this.$message({type:"warning",duration:5e3,showClose:!0,message:"您不是制单人不可修改！"})},cancelByParent:function(t,e){var i=this;this.$storage.get("userInfo").userId==t.makeId?this.$confirm("此操作将订单状态变更为已取消, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(l.cancelSaleOrder)(t.id).then(function(t){0===t.code&&(i.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),i.initExpandTable())}).catch(function(t){})}).catch(function(){i.$message({type:"info",message:"已取消操作"})}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"您不是制单人不可取消！"})},deleteByParent:function(t,e){var i=this;this.$storage.get("userInfo").userId==t.makeId?this.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(l.deleteSaleOrder)(t.id).then(function(t){0===t.code&&(i.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),i.initExpandTable())}).catch(function(t){})}).catch(function(){i.$message({type:"info",message:"已取消删除"})}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"您不是制单人不可删除！"})},executorByDetail:function(t,e){this.resetTemp(),this.dialogData.temp=t,this.dialogData.tempLable=this.tempLable,this.dialogData.title="查看执行人",this.openDialogName="dialogViewExecutor",this.showDialog=!0,this.visible=!0},exportExcel:function(){}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{currentpage:function(){this.initExpandTable()}}},p=(i("PFL1"),i("KHd+")),g=Object(p.a)(u,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"createDeliver"},[t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2)])],1),t._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[i("el-col",{staticClass:"tableStyle"},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableContent"},[i("expand-table",{attrs:{initData:t.initData,childrenData:t.childrenData,configs:t.tableSets,currentpage:t.currentpage,maxLayer:t.maxLayer,apiObj:{apiName:t.expandTableApiList,apiParams:t.expandTableApiParams},updateViewData:t.updateViewData},on:{"update:currentpage":function(e){t.currentpage=e},databridge:t.databridge,"send-children-row":t.findChildByRow}})],1)],1)])],1),t._v(" "),t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);g.options.__file="index.vue";e.default=g.exports},N0OG:function(t,e,i){},Nm4q:function(t,e,i){"use strict";var n=i("78mO");i.n(n).a},PFL1:function(t,e,i){"use strict";var n=i("N0OG");i.n(n).a},Sy3O:function(t,e,i){"use strict";i.r(e);i("yt8O"),i("RW0V"),i("rE2o"),i("ioFf"),i("rGqo");var n=i("rwyD"),a=i("AUoE"),o=i("z0WU"),s=i("mSNy");function l(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}function r(t){return(r="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var c={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{queryType:null,productId:"",productType:"",dialogLoading:!1,isVisible:!1,inDialog:!0,tempLable:{},tempQuery:{},rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{fullscreen:!1,title:"",data:null},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},BaseTableLoading:!1,tableData:[],selectList:[],configs:{tableConfigs:[],isSingle:!0},pageData:null,pageNo:1,resState:null}},created:function(){var t=this.initData.orderDtlIds;this.initTable(!0,t)},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=r(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getListPage:function(t){if(t){this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(o.j)(t.result),i=this.addTableTitle(e);this.configs.tableConfigs=i,this.tableData=t.result.varList,this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})}},initTempData:function(t){var e=this;t.forEach(function(t){for(var i in t){var n=t[i];n.indexOf("_")>0&&("en"==s.a.locale?n=n.substring(n.indexOf("_")+1):"zh"==s.a.locale&&(n=n.substring(0,n.indexOf("_")))),e.tempLable[i]=n}})},addTableTitle:function(t){return t.forEach(function(t){var e=t.label;e.indexOf("_")>0&&("en"==s.a.locale?t.label=e.substring(e.indexOf("_")+1):"zh"==s.a.locale&&(t.label=e.substring(0,e.indexOf("_"))))}),t},initTable:function(t,e){var i=this;t&&(this.BaseTableLoading=!0),Object(n.listPageSaleOrderDetail)(function(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},n=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(n=n.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),n.forEach(function(e){l(t,e,i[e])})}return t}({},this.tempQuery,{ids:e,pageNo:this.pageNo})).then(function(e){i.getListPage(e),i.dialogLoading=!1,t&&(i.BaseTableLoading=!1)}).catch(function(t){i.dialogLoading=!1,i.BaseTableLoading=!1})},dialogOpen:function(){},dialogClose:function(t){this.$emit("close-dialog",t||{})},dataBridge:function(t){},saveSaleDeliver:function(){var t=this,e=this.tableData;if(null!=e&&0!=e.length){var i=[];e.forEach(function(t){i.push(t)});var n=JSON.stringify(i);Object(a.addSaleDeliver)({dtlJsonStr:n}).then(function(e){0===e.code&&(t.$notify({title:"成功",message:"保存成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条订单明细！"})}}},d=i("KHd+"),u=Object(d.a)(c,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{height:"500px"}},[i("el-row",{staticStyle:{"margin-left":"10px"}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.BaseTableLoading,expression:"BaseTableLoading"}],staticStyle:{height:"400px"}},[i("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,isSingle:t.configs.isSingle,pageData:t.pageData,currentpage:t.pageNo},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1)]),t._v(" "),i("el-row",{staticStyle:{height:"100px","text-align":"center"}},[i("el-button",{attrs:{type:"primary"},on:{click:t.saveSaleDeliver}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);u.options.__file="dialogOrderDetail.vue";e.default=u.exports},lZYi:function(t,e,i){"use strict";var n=i("wnxv");i.n(n).a},wnxv:function(t,e,i){},zDZ1:function(t,e,i){"use strict";i("rE2o"),i("ioFf"),i("f3/d"),i("9WTv");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var a={name:"dialog-add",props:["initData","visible"],components:{},data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},tempShow:{},rules:{},imageUrl:""}},created:function(){this.initData.temp&&(this.temp=this.initData.temp,this.initData.temp.qrcode&&(this.imageUrl="http://116.196.105.79:8080/"+this.initData.temp.qrcode)),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},download:function(){var t=this.imageUrl,e=document.createElement("a");e.style.display="none",e.href=t,e.setAttribute("download",this.temp.name),document.body.appendChild(e),e.click()},print:function(){var t=document.getElementById("printContent").innerHTML,e=document.body.innerHTML;return document.body.innerHTML=t,window.print(),window.location.reload(),document.body.innerHTML=e,!1}}},o=(i("lZYi"),i("Nm4q"),i("KHd+")),s=Object(o.a)(a,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"二维码",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("div",{attrs:{id:"printContent"}},[i("el-form",{ref:"submitForm",staticStyle:{width:"400px",margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{staticStyle:{"text-align":"center","padding-bottom":"20px"},attrs:{span:24}},[t.imageUrl?i("img",{staticClass:"avatar",attrs:{src:t.imageUrl}}):i("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:24}},[i("b",{staticStyle:{"padding-left":"35%"}},[t._v(t._s(t.tempLable.code)+":")]),t._v(t._s(t.temp.code)),i("br"),t._v(" "),i("b",{staticStyle:{"padding-left":"35%"}},[t._v(t._s(t.tempLable.name)+":")]),t._v(t._s(t.temp.name)+"\n\n          ")])],1)],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center",padding:"15px 0 15px 0"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.download}},[t._v("下载")]),t._v(" "),i("el-button",{attrs:{type:"primary"},on:{click:t.print}},[t._v("打印")])],1)])])},[],!1,null,"c9e885e4",null);s.options.__file="dialogQrcode.vue";e.a=s.exports}}]);