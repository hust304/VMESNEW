(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-6c0f","chunk-7de0","chunk-259c","chunk-f804"],{"2WVR":function(e,t,i){"use strict";var a=i("AGgG");i.n(a).a},"9WTv":function(e,t,i){"use strict";i.d(t,"d",function(){return n}),i.d(t,"a",function(){return o}),i.d(t,"f",function(){return s}),i.d(t,"e",function(){return l}),i.d(t,"b",function(){return r}),i.d(t,"c",function(){return c});var a=i("t3Un");function n(e){return Object(a.a)({url:"/base/equipment/listPageEquipments",method:"post",data:e})}function o(e){return Object(a.a)({url:"/base/equipment/addEquipment",method:"post",data:e})}function s(e){return Object(a.a)({url:"/base/equipment/updateEquipment",method:"post",data:e})}function l(e,t){return Object(a.a)({url:"/base/equipment/update",method:"post",data:{id:e,isdisable:t}})}function r(e){return Object(a.a)({url:"/base/equipment/deleteByIds",method:"post",data:{ids:e}})}function c(e){return Object(a.a)({url:"/base/equipment/exportExcelEquipments",method:"post",responseType:"blob",data:{ids:e}})}},AGgG:function(e,t,i){},IfZh:function(e,t,i){"use strict";i.d(t,"b",function(){return n}),i.d(t,"a",function(){return o}),i.d(t,"c",function(){return s});var a=i("t3Un");function n(e){return Object(a.a)({url:"/warehouse/warehouseInDispatch/listPageWarehouseInDetail",method:"post",data:e})}function o(e){return Object(a.a)({url:"/warehouse/warehouseInDispatch/findWarehouseListByWarehouseIn",method:"post",data:e})}function s(e){return Object(a.a)({url:"/warehouse/warehouseInDispatch/updateWarehouseInDispatch",method:"post",data:e})}},"P3+s":function(e,t,i){"use strict";i.r(t);i("yt8O"),i("RW0V"),i("rE2o"),i("ioFf"),i("rGqo");var a=i("IfZh"),n=i("zF5t"),o=i("oC0i"),s=i("WnSj"),l=i("z0WU"),r=i("mSNy");function c(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}function d(e){return(d="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var u={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t\t\t<el-button v-show="colConfig.changeWarehouse_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.changeWarehouse(scope.row,scope.$index)">更改/增加货位</el-button>\n    \t\t\t\t\t\t\t\x3c!--<el-button  v-show="colConfig.qrcodeBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.qrcodeBtns(scope.row,scope.$index)">二维码</el-button>--\x3e\n    \t\t\t\t\t</div>\n\n  \t\t\t\t</el-table-column>'},h={components:{dialogRoleUser:o.default,dialogChangeWarehouseByIn:s.default},name:"dialog-add",props:["initData","visible"],data:function(){return{roleId:"",roleName:"",type:"",userData:[],userId:[],isSingle:!0,rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",temp:{},tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempQuery:{},tableData:[],selectList:null,tableIndex:null,initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",isPropName:!0,component:u,changeWarehouse:this.changeWarehouse,changeWarehouse_isShow:!0}},configs:{tableConfigs:[],showCheckBox:!1,showIndex:!1},pageData:null,pageNo:1}},created:function(){this.tableIndex=null,this.roleId=this.initData.temp.roleId,this.roleName=this.initData.temp.roleName,this.type=this.initData.temp.type,this.initUserData(),this.initTable()},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=d(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(l.m)(e.result),i=this.addTableTitle(t);this.configs.tableConfigs=i,this.tableData=e.result.varList}},initTempData:function(e){var t=this;e.forEach(function(e){for(var i in e){var a=e[i];a.indexOf("_")>0&&("en"==r.a.locale?a=a.substring(a.indexOf("_")+1):"zh"==r.a.locale&&(a=a.substring(0,a.indexOf("_")))),t.tempLable[i]=a}})},addTableTitle:function(e){return e.forEach(function(e){var t=e.label;t.indexOf("_")>0&&("en"==r.a.locale?e.label=t.substring(t.indexOf("_")+1):"zh"==r.a.locale&&(e.label=t.substring(0,t.indexOf("_"))))}),this.internationalConfig(),e.push(this.initConfigs.tableOperates),e},internationalConfig:function(){"en"==r.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==r.a.locale&&(this.initConfigs.tableOperates.label="操作")},initTable:function(){var e=this,t="",i=this.initData.temp;null!=i&&i.length>0&&i.forEach(function(e){null!=e.id&&e.id.trim().length>0&&(t=0==t.length?"'"+e.id.trim()+"'":t+",'"+e.id.trim()+"'")});var n="";null!=t&&t.trim().length>0&&(n="a.id in ("+t+")"),this.dialogLoading=!0,Object(a.b)(function(e){for(var t=1;t<arguments.length;t++){var i=null!=arguments[t]?arguments[t]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(e){return Object.getOwnPropertyDescriptor(i,e).enumerable}))),a.forEach(function(t){c(e,t,i[t])})}return e}({},this.tempQuery,{queryStr:n,fieldCode:"parentCode,productCode,productName,productSpec,productGenreName,productUnitName,count,code,warehouseName",pageNo:this.pageNo})).then(function(t){e.getListPage(t),e.dialogLoading=!1}).catch(function(t){e.dialogLoading=!1})},initUserData:function(){var e=this;this.userData=[],Object(n.findListUserByRole)({userIsdisable:"1",queryStr:"role.id = '"+this.roleId+"'"}).then(function(t){var i=t.result.options;null!=i&&i.length>0&&i.forEach(function(t){var i=t.id,a=t.userName;null!=i&&i.trim().length>0&&null!=a&&a.trim().length>0&&e.userData.push({key:i,label:a,disabled:!1})})}).catch(function(e){})},dataBridge:function(e){},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",e||{})},leftCheckChange:function(e){this.isSingle&&this.singleUserData(e)},singleUserData:function(e){var t=this.userData;if(null!=t&&0!=t.length)if(0==e.length)t.forEach(function(e){e.disabled=!1});else if(e.length>0){var i="";e.forEach(function(e){i=i+e+","}),t.forEach(function(e){var t=e.key;-1==i.indexOf(t)&&(e.disabled=!0)})}},addAdmin:function(){var e=this.roleId,t=this.roleName;this.dialogData.temp.roleId=e,this.dialogData.title=t+"-分配用户",this.openDialogName="dialogRoleUser",this.showDialog=!0,this.inLinVisible=!0},saveDispatch:function(){var e=this,t=this.roleId,i=this.roleName;this.type;if(null!=t&&0!=t){if(null==this.userData||0==this.userData.length)return this.dialogData.temp.roleId=t,this.dialogData.title=i+"-分配用户",this.openDialogName="dialogRoleUser",this.showDialog=!0,void(this.inLinVisible=!0);if(null!=this.userId&&0!=this.userId.length){var n=this.tableData,o="";if(null!=n&&0!=n.length){for(var s=[],l=0;l<n.length;l++){var r=n[l],c={id:"",warehouseId:"",taskName:""};c.id=r.id,c.warehouseId=r.warehouseId,c.taskName=r.parentCode+"_"+r.productName,s.push(c)}if(o=JSON.stringify(s),this.temp.dtlJsonStr=o,this.isSingle&&this.userId.length>1)this.$message({type:"warning",duration:5e3,showClose:!0,message:"请选择一位执行人，执行人只允许单选！"});else{this.temp.executeId="";for(var d=0;d<this.userId.length;d++){var u=this.userId[d];null!=u&&u.trim().length>0&&(this.temp.executeId=this.temp.executeId+u+",")}Object(a.c)(this.temp).then(function(t){0===t.code&&(e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(e){})}}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一样货品！"})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请选择执行人！"})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"仓库管理员角色ID为空或空字符串！"})},changeWarehouse:function(e,t){this.temp=JSON.parse(JSON.stringify(e)),this.tableIndex=t,this.dialogData.temp=this.temp,this.dialogData.title="更改/增加货位",this.openDialogName="dialogChangeWarehouseByIn",this.showDialog=!0,this.inLinVisible=!0},closeDialog:function(e){if(null!=e&&"dialogChangeWarehouseByIn"==e.pageName&&null!=this.tableIndex){var t=e.id,i=e.pathName;null!=this.tableData&&null!=this.tableData[this.tableIndex]&&(this.tableData[this.tableIndex].warehouseId=t,this.tableData[this.tableIndex].warehouseName=i)}this.inLinVisible=!1,this.showDialog=!1,this.initUserData()}},watch:{pageNo:function(){this.initTable()}}},p=i("KHd+"),g=Object(p.a)(h,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-row",{staticStyle:{height:"300px","margin-top":"15px",width:"96%","margin-left":"2%"}},[i("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1),e._v(" "),i("el-row",{staticStyle:{"text-align":"center"}},[i("el-transfer",{staticStyle:{"text-align":"left",display:"inline-block"},attrs:{data:e.userData,titles:["仓库管理员","执行人"]},on:{"left-check-change":e.leftCheckChange},model:{value:e.userId,callback:function(t){e.userId=t},expression:"userId"}},[i("span",{staticStyle:{"font-size":"12px",color:"#1482f0",cursor:"pointer"},attrs:{slot:"left-footer"},on:{click:e.addAdmin},slot:"left-footer"},[e._v(" +添加仓库管理员")])])],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.saveDispatch}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);g.options.__file="dialogDispatch.vue";t.default=g.exports},QzUw:function(e,t,i){},"Wc/n":function(e,t,i){},WnSj:function(e,t,i){"use strict";i.r(t);i("yt8O"),i("RW0V"),i("rE2o"),i("ioFf"),i("rGqo"),i("f3/d");var a=i("K3g7"),n=i("IfZh"),o=i("z0WU"),s=i("mSNy");function l(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}function r(e){return(r="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var c={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{queryType:null,productId:"",productType:"",dialogLoading:!1,isVisible:!1,inDialog:!0,tempLable:{},tempQuery:{},rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{fullscreen:!1,title:"",data:null},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},BaseTableLoading:!1,tableData:[],selectList:[],configs:{tableConfigs:[],isSingle:!0,showCheckBox:!1,showIndex:!1},pageData:null,pageNo:1,resState:null}},created:function(){var e=this.initData.temp;this.productId=e.productId,this.productType=e.productType,this.initTree()},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=r(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{treeDataBridge:function(e){this.selectTree={pid:e.nodeData.pid,id:e.nodeData.id,name:e.nodeData.name},this.pageNo=1,this.radioChange()},initTree:function(){var e=this;this.dialogLoading=!0;var t=this;Object(a.treeWarehouse)({}).then(function(e){var i=[],a=e.result.treeList;t.selectTree={pid:a.pid,id:a.id,name:a.name},i.push(a),t.treeData=i,t.initTable(null,null,null,null,null),t.$nextTick(function(){t.$refs.tree.$children[0].setCurrentKey(t.selectTree.id)})}).catch(function(t){e.dialogLoading=!1})},getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(o.m)(e.result),i=this.addTableTitle(t);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=e.result.varList,this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})}},initTempData:function(e){var t=this;e.forEach(function(e){for(var i in e){var a=e[i];a.indexOf("_")>0&&("en"==s.a.locale?a=a.substring(a.indexOf("_")+1):"zh"==s.a.locale&&(a=a.substring(0,a.indexOf("_")))),t.tempLable[i]=a}})},addTableTitle:function(e){return e.forEach(function(e){var t=e.label;t.indexOf("_")>0&&("en"==s.a.locale?e.label=t.substring(t.indexOf("_")+1):"zh"==s.a.locale&&(e.label=t.substring(0,t.indexOf("_"))))}),e},initTable:function(e,t,i,a,o){var s=this;null!=t&&0!=t.trim().length||(t=""),null!=i&&0!=i.trim().length||(i=""),null!=a&&0!=a.trim().length||(a=""),null!=o&&0!=o.trim().length||(o=""),e&&(this.BaseTableLoading=!0),Object(n.a)(function(e){for(var t=1;t<arguments.length;t++){var i=null!=arguments[t]?arguments[t]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(e){return Object.getOwnPropertyDescriptor(i,e).enumerable}))),a.forEach(function(t){l(e,t,i[t])})}return e}({},this.tempQuery,{nodeId:t,productId:i,productType:a,isExistProd:o,pageNo:this.pageNo})).then(function(t){s.getListPage(t),s.dialogLoading=!1,e&&(s.BaseTableLoading=!1)}).catch(function(e){s.dialogLoading=!1,s.BaseTableLoading=!1})},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",e||{})},radioChange:function(){var e="",t="",i="";"productId"==this.queryType?(e=this.productId,i="true"):"productType"==this.queryType?(t=this.productType,i="true"):"warehouseId"==this.queryType&&(i="false");var a="";null!=this.selectTree&&null!=this.selectTree.id&&this.selectTree.id.trim().length>0&&(a=this.selectTree.id.trim()),this.initTable(!0,a,e,t,i)},dataBridge:function(e){if(null!=e&&e.length>0){var t=e[0];t.pageName="dialogChangeWarehouseByIn",this.selectList.push(t)}},save:function(){this.isVisible=!1,this.dialogClose(this.selectList[0])}},watch:{pageNo:function(){this.initTable()}}},d=(i("2WVR"),i("KHd+")),u=Object(d.a)(c,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{height:"500px"}},[i("el-col",{staticClass:"treeStyle",attrs:{span:4}},[i("base-tree",{ref:"tree",attrs:{data:e.treeData,treeConfigs:e.treeConfigs},on:{treedatabridge:e.treeDataBridge}})],1),e._v(" "),i("el-col",{attrs:{span:20}},[i("el-row",[i("el-radio-group",{staticStyle:{padding:"10px 10px"},on:{change:e.radioChange},model:{value:e.queryType,callback:function(t){e.queryType=t},expression:"queryType"}},[i("el-radio",{attrs:{label:"productId"}},[e._v("相同货品")]),e._v(" "),i("el-radio",{attrs:{label:"productType"}},[e._v("相同货品分类")]),e._v(" "),i("el-radio",{attrs:{label:"warehouseId"}},[e._v("空货位")])],1)],1),e._v(" "),i("div",{staticClass:"tableContent",staticStyle:{"margin-left":"10px"}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.BaseTableLoading,expression:"BaseTableLoading"}],staticStyle:{height:"400px"}},[i("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,isSingle:e.configs.isSingle,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1)]),e._v(" "),i("el-row",{staticStyle:{height:"100px","text-align":"center"}},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)],1)},[],!1,null,null,null);u.options.__file="dialogChangeWarehouseByIn.vue";t.default=u.exports},bNCw:function(e,t,i){"use strict";var a=i("QzUw");i.n(a).a},hzOv:function(e,t,i){"use strict";i.r(t);i("rGqo");var a=i("zDZ1"),n=i("2+ib"),o=i("uTIz"),s=i("P3+s"),l=i("zF5t"),r=i("Vobf"),c=(i("z0WU"),{components:{dialogQrcode:a.a,multilevelTable:n.a,searchBar:o.a,dialogDispatch:s.default},data:function(){return{searchList:[{label:"入库单号",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"入库单号"},{label:"入库类型",type:"input",ruleType:"string",mapKey:"typeName",configs:{},placeholder:"入库类型"},{label:"仓库名称",type:"input",ruleType:"string",mapKey:"warehouseName",configs:{},placeholder:"仓库名称"},{label:"来源单位",type:"input",ruleType:"string",mapKey:"deptName",configs:{},placeholder:"来源单位"},{label:"货品编码",type:"input",ruleType:"string",mapKey:"productCode",configs:{},placeholder:"货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"货品名称"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"productSpec",configs:{},placeholder:"规格型号"},{label:"货品属性",type:"input",ruleType:"string",mapKey:"productGenreName",configs:{},placeholder:"货品属性"},{label:"计量单位",type:"input",ruleType:"string",mapKey:"productUnitName",configs:{},placeholder:"请输入计量单位"}],guid:"",tableConfigList:[{customColumn:[{columnIndex:"code"},{columnIndex:"typeName"},{columnIndex:"warehouseName"},{columnIndex:"deptName"},{columnIndex:"makeName"},{columnIndex:"cdate"},{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"1",text:"已完成"},info:{state:"-1",text:"已取消"},default:{state:"0",text:"未完成"}}}],apiObj:{apiName:"listPageWarehouseIn",params:{orderStr:" a.code desc ",detailState:"0"}},tempData:{},showHeader:!1,showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"2",text:"已完成"},warning:{state:"1",text:"执行中"},info:{state:"-1",text:"已取消"},default:{state:"0",text:"待派单"}}}],apiObj:{apiName:"listPageWarehouseInDetail",params:{isNeedPage:"false",state:"0"}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!0,isSingle:!1,componentId:"twoLevelTable"}],searchObj:{},selectList:[],configs:{topBarBtnList:[{name:"派单",nameEn:"dispatch",isShow:!0,icon:"add",method:this.dispatchWarehouseIn}],tableConfigs:[]},temp:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:{roleId:"",roleName:"",type:""},tempLable:null}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var e=this,t=e.$storage.get("userInfo").roleIds,i=e.$storage.get("menuId");t&&(e.$loading({spinner:"none",text:"智 造 云 管 家"}),Object(r.initMenuButtons)({menuId:i,roleId:t}).then(function(t){e.$loading().close();var i=t.buttonList;i&&i.forEach(function(t){e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}))})}).catch(function(t){e.$loading().close()}))},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},databridge:function(e){this.selectList=e},qrcodeByDetail:function(e,t){this.resetTemp(),this.temp=JSON.parse(JSON.stringify(item)),this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="二维码",this.openDialogName="dialogQrcode",this.showDialog=!0,this.visible=!0},sendGuid:function(e){this.guid=e},searchMap:function(e){this.searchObj=e,this.updateData(this.searchObj)},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&this.updateData(this.searchObj)},dispatchWarehouseIn:function(){var e=this.selectList;null!=e&&0!=e.length?this.isExistWarehouseRole(e):this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条明细！"})},isExistWarehouseRole:function(e){var t=this,i={userType:this.$storage.get("userInfo").userType,roleName:"仓库管理员"};Object(l.addRoleByName)(i).then(function(i){var a=i.result,n=a.type,o=a.roleId,s=a.roleName;null!=o&&0!=o.trim().length?(t.dialogData.temp=e,t.dialogData.temp.roleId=o,t.dialogData.temp.roleName=s,t.dialogData.temp.type=n,t.dialogData.title="入库单派单",t.openDialogName="dialogDispatch",t.showDialog=!0,t.visible=!0):t.$message({type:"warning",duration:5e3,showClose:!0,message:"仓库管理员角色ID不存在(角色ID为空或空字符串)！"})}).catch(function(e){})},exportExcel:function(){}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}}),d=(i("kkqt"),i("KHd+")),u=Object(d.a)(c,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"warehouseInManage"},[e.searchList.length?i("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[e._l(e.configs.topBarBtnList,function(e,t){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state},on:{myclick:e.method}})]})],2)])],1),e._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[i("el-col",{staticClass:"tableStyle"},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableContent"},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1)],1)])],1),e._v(" "),e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);u.options.__file="index.vue";t.default=u.exports},kkqt:function(e,t,i){"use strict";var a=i("n5Pu");i.n(a).a},lZYi:function(e,t,i){"use strict";var a=i("wnxv");i.n(a).a},n5Pu:function(e,t,i){},oC0i:function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf"),i("rGqo"),i("f3/d");var a=i("ukxx"),n=i.n(a),o=i("Do8I"),s=i("zF5t"),l=i("z0WU");function r(e){return(r="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var c={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{roleId:"",rules:{},temp:{},tempLable:{},tempNotEditable:{},dialogLoading:!1,isVisible:!1,inDialog:!0,openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{fullscreen:!1,title:"",data:null},assignTree:[],assignTreeConfigs:{showSearch:!0},assignCheckedList:[],assignFilterText:"",dialogAssignChecked:!1,clickArrow:!1,defaultProps:{children:"children",label:"url"},treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},transferData:[],transferSelectedData:[],renderFunc:function(e,t){return e("span",{style:"display: inline-block;width: 100%;"},[" ",e("span",{style:"display: inline-block;width: 20%;text-align: center;"},[" ",t.index]),e("span",{style:"display: inline-block;width: 39%;text-align: center;"},[t.userCode])," ",e("span",{style:"display: inline-block;width: 39%;text-align: center;"},[" ",t.userName])])},transferProps:{key:"id",label:"userName",code:"userCode",disabled:"isdisable",index:"index"},resState:null}},created:function(){this.initData.temp&&(this.temp=this.initData.temp),this.roleId=this.temp.roleId,this.treeDepartments();var e=this.$storage.get("userInfo").companyId;this.assignTreeDataBridge({id:e})},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=r(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){this.$nextTick(function(){if(!document.getElementsByClassName("customTitle").length)for(var e=document.getElementsByClassName("el-transfer-panel__filter"),t=0;t<e.length;t++){var i=(new(n.a.extend({template:'<div class="customTitle" style="box-sizing: border-box;padding: 5px 0 5px 41px;height: 25px;box-shadow:0 3px 5px -3px rgba(0,0,0,0.3);">\n                        <span style="display: inline-block;width: 100%;">\n                        <span style="display: inline-block;width: 20%;text-align: center;">序号</span>\n                        <span style="display: inline-block;width: 37%;text-align: center;">账号</span>\n                        <span style="display: inline-block;width: 38%;text-align: center;">姓名</span>\n                        </span>\n                      </div>'}))).$mount(),a=e[t],o=a.parentNode,s=a.nextSibling;s?o.insertBefore(i.$el,s):o.appendChild(i.$el)}})},dialogClose:function(e){this.$emit("close-dialog",e||{})},assignFilterNode:function(e,t){return!e||-1!==t.name.indexOf(e)},treeDepartments:function(){var e=this;this.dialogLoading=!0,Object(o.treeDepartments)({isdisable:"1"}).then(function(t){e.assignTree=[t.result.treeList],e.$nextTick(function(t){e.$refs.assignTree.setCurrentKey(e.assignTree[0].id)})}).catch(function(t){e.dialogLoading=!1})},assignFilterKey:function(e){var t=[];return e.forEach(function(e){t.push(e.id)}),t},assignTreeDataBridge:function(e){var t=this;this.transferData=[],this.transferSelectedData=[];var i={deptId:e.id,roleId:this.roleId},a={roleId:this.roleId};this.$axios.all([Object(s.listUsersByRole)(a),Object(s.listAllUsersByDeptId)(i)]).then(this.$axios.spread(function(e,i){var a=Object(l.s)(e.result.varList.concat(i.result.varList));a.forEach(function(e,t){e.index=t+1}),t.transferData=a,t.transferSelectedData=t.assignFilterKey(e.result.varList),t.$loading().close(),t.dialogLoading=!1})).catch(function(e){t.$loading().close(),t.dialogLoading=!1})},handleChange:function(e,t,i){},saveUsersByRole:function(){var e=this;Object(s.saveRoleUsers)({roleId:this.roleId,userIds:Object(l.l)(this.transferSelectedData)}).then(function(t){0===t.code&&(e.$notify({title:"成功",message:"保存成功",type:"success",duration:1e3}),e.isVisible=!1,e.dialogClose({resState:"ok"})),e.$loading().close()}).catch(function(t){e.$loading().close()})},closeDialog:function(e){this.showDialog=!1}}},d=(i("uoYy"),i("KHd+")),u=Object(d.a)(c,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"850px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{height:"500px"}},[i("el-col",{staticStyle:{position:"relative",height:"100%",overflow:"hidden"},attrs:{span:6}},[i("div",{staticStyle:{position:"absolute",top:"-10px",bottom:"-10px",left:"0",right:"5px","background-color":"#EBF0F6","box-shadow":"5px 0 10px -5px rgba(0,0,0,0.3)","box-sizing":"border-box",padding:"10px 0"}},[i("div",{staticClass:"leftTree",staticStyle:{height:"100%","padding-top":"10px"}},[i("el-input",{attrs:{placeholder:"",clearable:""},model:{value:e.assignFilterText,callback:function(t){e.assignFilterText=t},expression:"assignFilterText"}},[i("i",{staticClass:"el-input__icon el-icon-search",attrs:{slot:"suffix"},slot:"suffix"})]),e._v(" "),i("div",{staticClass:"treeView",staticStyle:{height:"calc(100% - 85px)",overflow:"auto"}},[i("el-tree",{ref:"assignTree",attrs:{"highlight-current":"","default-expand-all":"","node-key":"id","expand-on-click-node":e.clickArrow,data:e.assignTree,props:e.defaultProps,"filter-node-method":e.assignFilterNode},on:{"node-click":e.assignTreeDataBridge},scopedSlots:e._u([{key:"default",fn:function(t){var a=t.node,n=t.data;return i("span",{staticClass:"custom-tree-node"},[e.treeConfigs.showIcons?i("svg-icon",{staticStyle:{"margin-right":"5px"},attrs:{"icon-class":n.url}}):e._e(),e._v(" "),a.label?i("span",[e._v(e._s(a.label))]):i("span",[e._v(e._s(n.name))])],1)}}])})],1)],1)])]),e._v(" "),i("el-col",{staticStyle:{height:"100%"},attrs:{span:18}},[i("div",{staticStyle:{height:"calc(100% - 60px)","box-sizing":"border-box",padding:"7px 0"}},[i("div",{staticStyle:{"text-align":"center"}},[i("el-transfer",{staticStyle:{"text-align":"left",display:"inline-block"},attrs:{filterable:"",props:e.transferProps,"left-default-checked":[],"right-default-checked":[],"render-content":e.renderFunc,titles:["未分配用户","已分配用户"],format:{noChecked:"${total}",hasChecked:"${checked}/${total}"},data:e.transferData},on:{change:e.handleChange},model:{value:e.transferSelectedData,callback:function(t){e.transferSelectedData=t},expression:"transferSelectedData"}})],1)]),e._v(" "),i("div",{staticStyle:{position:"relative",height:"60px","text-align":"center","box-sizing":"border-box",padding:"10px 0 0 0"}},[i("el-button",{attrs:{type:"primary"},on:{click:e.saveUsersByRole}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)])],1)],1)},[],!1,null,null,null);u.options.__file="dialogRoleUser.vue";t.default=u.exports},uoYy:function(e,t,i){"use strict";var a=i("Wc/n");i.n(a).a},wnxv:function(e,t,i){},zDZ1:function(e,t,i){"use strict";i("rE2o"),i("ioFf"),i("f3/d"),i("9WTv");function a(e){return(a="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var n={name:"dialog-add",props:["initData","visible"],components:{},data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},tempShow:{},rules:{},imageUrl:""}},created:function(){console.log(this.initData),this.initData.temp&&(this.temp=this.initData.temp,this.initData.temp.qrcode&&(this.imageUrl="http://vmes.deecoop.cn/"+this.initData.temp.qrcode)),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=a(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},download:function(){var e=this.imageUrl,t=document.createElement("a");t.style.display="none",t.href=e,t.setAttribute("download",this.temp.name),document.body.appendChild(t),t.click()},print:function(){var e='<!DOCTYPE html> <html> <head> <meta charset="utf-8"> <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> ';e+="<style></style>",e+="</head><body >",e+=document.getElementById("printContent").innerHTML,e+="</body></html>";var t=window.open("","打印","");t.document.write(e),t.document.close(),t.focus(),t.print(),t.close()}}},o=(i("lZYi"),i("bNCw"),i("KHd+")),s=Object(o.a)(n,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"二维码",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"400px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("div",{attrs:{id:"printContent"}},[i("el-form",{ref:"submitForm",staticStyle:{width:"400px",margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{staticStyle:{"text-align":"center","padding-bottom":"20px"},attrs:{span:24}},[e.imageUrl?i("img",{staticClass:"avatar",staticStyle:{margin:"0 auto"},attrs:{src:e.imageUrl}}):i("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1),e._v(" "),i("el-row",[i("el-col",{attrs:{span:24}},[i("b",{staticStyle:{"padding-left":"35%"}},[e._v(e._s(e.tempLable.code)+":")]),e._v(e._s(e.temp.code)),i("br"),e._v(" "),i("b",{staticStyle:{"padding-left":"35%"}},[e._v(e._s(e.tempLable.name)+":")]),e._v(e._s(e.temp.name)+"\n\n          ")])],1)],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center",padding:"15px 0 15px 0"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.download}},[e._v("下载")]),e._v(" "),i("el-button",{attrs:{type:"primary"},on:{click:e.print}},[e._v("打印")])],1)])])},[],!1,null,"48eacded",null);s.options.__file="dialogQrcode.vue";t.a=s.exports}}]);