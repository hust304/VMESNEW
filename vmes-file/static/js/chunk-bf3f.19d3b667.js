(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-bf3f"],{"/FKj":function(t,e,i){"use strict";i.r(e);i("91GP"),i("rGqo");var a=i("zDZ1"),n=i("lX1r"),o=i("uTIz"),l=i("MR/n"),r=i("IbvJ"),s=i("8Vv6"),c=i("rwyD"),u=i("Vobf");i("z0WU");function d(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}var p={props:["colConfig"],template:'<el-table-column :label="colConfig.label" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t    \x3c!--<el-button v-show="colConfig.infoByParent_isShow" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.infoByParent(scope.row,scope.$index)">详情</el-button>--\x3e\n    \t\t\t\t\t    <el-button v-show="colConfig.editByParent_isShow && scope.row.state == \'0\'" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.editByParent(scope.row,scope.$index)">编辑</el-button>\n    \t\t\t\t\t    <el-button v-show="colConfig.deleteByParent_isShow && (scope.row.state == \'0\' || scope.row.state == \'-1\')" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.deleteByParent(scope.row,scope.$index)">删除</el-button>\n    \t\t\t\t\t\t\t<el-button v-show="colConfig.cancelByParent_isShow && scope.row.state == \'0\'" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.cancelByParent(scope.row,scope.$index,scope)">取消</el-button>\n    \t\t\t\t\t\t\t\x3c!--<el-button v-show="colConfig.recoveryByParent_isShow && scope.row.state == \'-1\'" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.recoveryByParent(scope.row,scope.$index,scope)">恢复</el-button>--\x3e\n    \t\t\t\t\t</div>\n  \t\t\t\t</el-table-column>'},m={components:{dialogQrcode:a.a,expandTable:n.a,searchBar:o.a,dialogAdd:l.default,dialogEdit:r.default},data:function(){var t;return d(t={colConfigs:[],initData:{},childrenDialogTitleList:[],fromTemp:{},showDialog:!1,dialogVisible:!1,dialogCallBackData:null,baseLayer:0,searchList:[{label:"订单编号",type:"input",ruleType:"string",mapKey:"sysCode",configs:{},placeholder:"订单编号"},{label:"客户名称",type:"input",ruleType:"string",mapKey:"customerName",configs:{},placeholder:"客户名称"},{label:"发票类型",type:"select",ruleType:"string",mapKey:"receiptType",configs:{clearable:!0,name:"",options:[{value:"1",label:"不开票"},{value:"2",label:"普通发票"},{value:"3",label:"增值税发票"}]},placeholder:"请选择"},{label:"下单日期起",type:"date",ruleType:"date",mapKey:"orderDateBegin",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"},{label:"下单日期止",type:"date",ruleType:"date",mapKey:"orderDateEnd",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"},{label:"约定交期",type:"date",ruleType:"date",mapKey:"deliverDate",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"},{label:"订单状态",type:"select",ruleType:"string",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"0",label:"待提交"},{value:"1",label:"待审核"},{value:"2",label:"待发货"},{value:"3",label:"已发货"},{value:"4",label:"已完成"},{value:"-1",label:"已取消"}]},placeholder:"请选择"}],guid:"",currentpage:1,maxLayer:2,expandTableApiList:["listPageSaleOrder","listPageSaleOrderDetail"],expandTableApiParams:[{priceType:"1"},{parentId:""}],initParams:{},updateViewData:{},searchObj:{},titleList:[],pageData:{},childrenData:{},customColumn:{1:[{columnIndex:"last",prop:"operate",label:"操作",component:p,editByParent:this.editByParent,editByParent_isShow:!0,cancelByParent:this.cancelByParent,cancelByParent_isShow:!0,deleteByParent:this.deleteByParent,deleteByParent_isShow:!0}]},tableSets:{1:{showCheckBox:!0,showIndex:!0,expandOne:!1},2:{showCheckBox:!1,showIndex:!1,isExpands:!1,isSortable:!1,isSingle:!1}},configs:{topBarBtnList:[{name:"新增",nameEn:"add",isShow:!0,icon:"add",method:this.dialogAdd},{name:"提交",nameEn:"submit",isShow:!0,icon:"add",method:this.orderSubmit}],tableConfigs:[],showCheckBox:!1},temp:{},openDialogName:""},"showDialog",!1),d(t,"visible",!1),d(t,"dialogData",{title:"",temp:null,tempLable:null}),t},beforeCreate:function(){},created:function(){this.initButtons(),this.initExpandTable()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var t=this;t.$loading({spinner:"none",text:"智 造 云 管 家"});var e=t.$storage.get("userInfo").roleIds,i=t.$storage.get("menuId");e&&Object(u.initMenuButtons)({menuId:i,roleId:e}).then(function(e){var i=e.buttonList;i&&i.forEach(function(e){if(t.initConfigs&&t.initConfigs.tableOperates)for(var i in t.initConfigs.tableOperates)i.indexOf(e.nameEn)>=0&&i.indexOf("isShow")>0&&(t.initConfigs.tableOperates[i]=!1);if(t.customColumn)for(var a in t.customColumn)if(a){var n=t.customColumn[a];n.length>0&&n.forEach(function(t){if(t)for(var i in t)i.indexOf(e.nameEn)>=0&&i.indexOf("isShow")>0&&(t[i]=!1)})}t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}))})}).catch(function(e){t.$loading().close()})},initExpandTable:function(){var t=this;this.$api[this.expandTableApiList[0]](this.setParams(1,this.expandTableApiParams[0],this.currentpage)).then(function(e){t.initData={row:null,layer:1,res:e,customColumn:t.customColumn},t.$loading().close()}).catch(function(e){t.$loading().close()})},databridge:function(t){this.temp.dataList=t},findChildByRow:function(t,e,i,a,n){var o=this;this.$api[this.expandTableApiList[e-1]](this.setParams(e,t,n)).then(function(i){o.childrenData={row:t,layer:e,res:i,customColumn:o.customColumn}}).catch(function(t){})},setParams:function(t,e,i){var a=Object.assign({},this.expandTableApiParams[t-1]);for(var n in a)a.hasOwnProperty(n)&&!a[n]&&(a[n]=e[n]||"");return Object.assign({},a,this.searchObj,{pageNo:i})},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.initExpandTable()},resetTemp:function(){for(var t in this.temp)this.temp[t]=""},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.initExpandTable()},dialogAdd:function(){this.dialogData.title="新增订单",this.openDialogName="dialogAdd",this.showDialog=!0,this.visible=!0},orderSubmit:function(){var t=this,e=[],i=this.temp.dataList;null!=i&&i.length>0&&i.forEach(function(t){null!=t.id&&t.id.trim().length>0&&e.push({id:t.id.trim()})}),0!=e.length?this.$confirm("此操作将订单提交, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var i=JSON.stringify(e);Object(s.submitSaleOrder)({orderJsonStr:i}).then(function(e){0===e.code&&(t.$notify({title:"成功",message:"提交成功",type:"success",duration:2e3}),t.initExpandTable())}).catch(function(t){})}).catch(function(){t.$message({type:"info",message:"已取消订单提交"})}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少勾选一条订单！"})},editByParent:function(t,e){this.$storage.get("userInfo").userId==t.makeId?(this.resetTemp(),this.dialogData.temp=t,this.dialogData.title="编辑订单",this.openDialogName="dialogEdit",this.showDialog=!0,this.visible=!0):this.$message({type:"warning",duration:5e3,showClose:!0,message:"您不是制单人不可修改！"})},cancelByParent:function(t,e){var i=this;this.$storage.get("userInfo").userId==t.makeId?this.$confirm("此操作将订单状态变更为已取消, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(s.cancelSaleOrder)(t.id).then(function(t){0===t.code&&(i.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),i.initExpandTable())}).catch(function(t){})}).catch(function(){i.$message({type:"info",message:"已取消操作"})}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"您不是制单人不可取消！"})},deleteByParent:function(t,e){var i=this;this.$storage.get("userInfo").userId==t.makeId?this.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(s.deleteSaleOrder)(t.id).then(function(t){0===t.code&&(i.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),i.initExpandTable())}).catch(function(t){})}).catch(function(){i.$message({type:"info",message:"已取消删除"})}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"您不是制单人不可删除！"})},cancelByDetail:function(t,e,i){var a=this;this.$storage.get("userInfo").userId==t.makeId?this.$confirm("此操作将订单明细状态变更为已取消, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(c.cancelSaleOrderDetail)(t.id).then(function(t){0===t.code&&(a.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),a.initExpandTable())}).catch(function(t){})}).catch(function(){a.$message({type:"info",message:"已取消操作"})}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"您不是制单人不可取消！"})},deleteByDetail:function(t,e){var i=this;this.$storage.get("userInfo").userId==t.makeId?this.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(c.deleteSaleOrderDetail)(t.id).then(function(t){0===t.code&&(i.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),i.initExpandTable())}).catch(function(t){})}).catch(function(){i.$message({type:"info",message:"已取消删除"})}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"您不是制单人不可删除！"})},executorByDetail:function(t,e){this.resetTemp(),this.dialogData.temp=t,this.dialogData.tempLable=this.tempLable,this.dialogData.title="查看执行人",this.openDialogName="dialogViewExecutor",this.showDialog=!0,this.visible=!0},exportExcel:function(){}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{currentpage:function(){this.initExpandTable()}}},h=(i("DZeo"),i("KHd+")),g=Object(h.a)(m,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"saleOrder"},[t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2)])],1),t._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[i("el-col",{staticClass:"tableStyle"},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableContent"},[i("expand-table",{attrs:{initData:t.initData,childrenData:t.childrenData,configs:t.tableSets,currentpage:t.currentpage,maxLayer:t.maxLayer,apiObj:{apiName:t.expandTableApiList,apiParams:t.expandTableApiParams},updateViewData:t.updateViewData},on:{"update:currentpage":function(e){t.currentpage=e},databridge:t.databridge,"send-children-row":t.findChildByRow}})],1)],1)])],1),t._v(" "),t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);g.options.__file="index.vue";e.default=g.exports},"9WTv":function(t,e,i){"use strict";i.d(e,"d",function(){return n}),i.d(e,"a",function(){return o}),i.d(e,"f",function(){return l}),i.d(e,"e",function(){return r}),i.d(e,"b",function(){return s}),i.d(e,"c",function(){return c});var a=i("t3Un");function n(t){return Object(a.a)({url:"/equipment/listPageEquipments",method:"post",data:t})}function o(t){return Object(a.a)({url:"/equipment/addEquipment",method:"post",data:t})}function l(t){return Object(a.a)({url:"/equipment/updateEquipment",method:"post",data:t})}function r(t,e){return Object(a.a)({url:"/equipment/update",method:"post",data:{id:t,isdisable:e}})}function s(t){return Object(a.a)({url:"/equipment/deleteByIds",method:"post",data:{ids:t}})}function c(t){return Object(a.a)({url:"/equipment/exportExcelEquipments",method:"post",responseType:"blob",data:{ids:t}})}},DZeo:function(t,e,i){"use strict";var a=i("br4E");i.n(a).a},"MR/n":function(t,e,i){"use strict";i.r(e);i("f3/d"),i("Oyvg");var a=i("3d3b"),n=i("WIyV"),o=i("8Vv6"),l=i("aZSg"),r=(i("rwyD"),i("a0Xs")),s={components:{customBaseTable:n.a,productTableDialog:a.a},props:["initData","visible"],data:function(){var t=this;return{productUnit:{},rowData:{},rules:{customerName:[{required:!0,message:"请选择客户名称",trigger:"change"}],receiptTypeName:[{required:!0,trigger:"change",validator:function(e,i,a){t.temp.receiptType.length<=0?a(new Error("请选择发票类型")):a()}}],makeName:[{required:!0,message:"请选择制单人",trigger:"change"}],orderDate:[{required:!0,message:"请填写下单日期",trigger:"change"}],expectDate:[{required:!0,message:"请填写约定交期",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,isNeedRepeat:!1,tempLable:null},dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{priceType:"1",customerId:"",customerName:"",receiptType:"",receiptTypeName:"",orderDate:new Date,expectDate:new Date,makeId:"",makeName:"",remark:"",dtlJsonStr:""},tempLable:{},tempQuery:{},tableData:[],orderDtlList:[],configs:{topBarBtnList:[{name:"选择货品",nameEn:"add",isShow:!0,icon:"add",method:this.addProduct}],tableConfigs:[],showCheckBox:!1,showIndex:!1},CustomerDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择客户名称",tableUrl:"/base/listPageDepartmentCustomer",tableParm:{queryStr:"a.type = '3'"},temp:{}},dialogName:"dialogOption"}},MakeDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择制单人",tableUrl:"/user/listPageUsers",tableParm:{fieldCode:"code,name,mobile,email,deptName,remark"},temp:{}},dialogName:"dialogOption"}},apiObj:{apiName:"listPageSaleOrderDetail",params:{pageNo:1,type:"add",fieldCode:"productCode,productName,productSpec,productGenreName,priceUnitName,count,productPrice,productSum,stockCountByPrice,productStockCountByPrice,deliverDate,remark"}},customColumn:[{columnIndex:"priceUnitName",componentName:"select",_cellConfig:{asyn:{apiName:"findListProductUnitByProduct",params:{productId:""}},rules:[{required:!0}],outputData:!0}},{columnIndex:"count",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}},{columnIndex:"productPrice",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}},{columnIndex:"productSum",_cellConfig:{hideTitle:!0,compute:"self@count(*)self@productPrice"}},{columnIndex:"deliverDate",componentName:"date",_cellConfig:{valueType:"date",format:"yyyy-MM-dd",valueFormat:"yyyy-MM-dd",lessThan:["tempData@maxExpectDate",!0]}},{columnIndex:"remark",componentName:"input",_cellConfig:{}}],mergeTitle:[],mergeColumn:[],mergeRow:[],keyMapping:{},tempData:{maxExpectDate:""}}},beforeCreate:function(){},created:function(){var t=this.$storage.get("userInfo");null!=t.userId&&t.userId.trim().length>0&&(this.temp.makeId=t.userId.trim()),null!=t.userName&&t.userName.trim().length>0&&(this.temp.makeName=t.userName.trim())},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(t){Array.isArray(t)?(this.orderDtlList=[],this.orderDtlList=t):(this.productUnit=null,null!=t.item&&(this.productUnit=t.item),this.rowData=null,null!=t.item&&(this.rowData=t.row),this.setProductPrice(this.productUnit,this.rowData),this.formulaReckonByProductCount_n2p(this.productUnit.n2pFormula,this.rowData),this.setProductSum(this.rowData))},save:function(){var t=this;this.$refs.submitForm.validate(function(e){e&&(t.$refs.orderAddDialog.getData(),t.saveSaleOrder(t.orderDtlList))})},isNumberByValue:function(t){return null!=t&&0!=t.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(t.trim())},checkColumn:function(t){for(var e="",i=this.temp.expectDate,a=0;a<t.length;a++){var n=t[a],o=n.count;null!=o&&0!=o.trim().length||(e=e+"第 "+(a+1)+" 行: 单位为空或空字符串！");var l=n.count;null!=l&&0!=l.trim().length||(e=e+"第 "+(a+1)+" 行: 订购数量为空或空字符串！");var r=n.productPrice;null!=r&&0!=r.trim().length||(e=e+"第 "+(a+1)+" 行: 单价为空或空字符串！");var s=n.deliverDate;null==s&&(e=e+"第 "+(a+1)+" 行: 约定交期为空或空字符串！"),null!=i&&null!=s&&i<s&&(e=e+"第 "+(a+1)+" 行: 约定交期不可大于("+i+")！"),null!=l&&l.trim().length>0&&!this.isNumberByValue(l.trim())&&(e=e+"第 "+(a+1)+" 行: 订购数量("+l+") 输入错误，请输入大于零的正整数或(1,2)位小数！"),null!=r&&r.trim().length>0&&!this.isNumberByValue(r.trim())&&(e=e+"第 "+(a+1)+" 行: 单价("+r+") 输入错误，请输入大于零的正整数或(1,2)位小数！")}return e},saveSaleOrder:function(t){var e=this;if(null!=t&&0!=t.length){var i=this.checkColumn(t);if(null!=i&&i.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:i});else{for(var a=[],n=0;n<t.length;n++){var l=t[n],r={productId:"",productPrice:"",p2nFormula:"",n2pFormula:"",productUnit:"",priceUnit:"",count:"",productSum:"",deliverDate:"",remark:""};r.productId=l.productId,r.productPrice=l.productPrice,r.p2nFormula=l.p2nFormula,r.n2pFormula=l.n2pFormula,r.productUnit=l.productUnit,r.priceUnit=l.priceUnit,r.count=l.count,r.productSum=l.productSum,r.deliverDate=l.deliverDate,r.remark=l.remark,a.push(r)}this.temp.dtlJsonStr="",null!=a&&a.length>0&&(this.temp.dtlJsonStr=JSON.stringify(a)),this.dialogLoading=!0,Object(o.addSaleOrder)(this.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){})}}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一样货品！"})},customerSelect:function(t){t[0]&&(this.temp.customerId=t[0].id,this.temp.customerName=t[0].name)},makeSelect:function(t){t[0]&&(this.temp.makeId=t[0].id,this.temp.makeName=t[0].name)},checkNumber:function(t,e){null!=t&&t.trim().length>0&&!this.isNumberByValue(t.trim())&&this.$message({type:"warning",duration:5e3,showClose:!0,message:e+"("+t+") 输入错误，请输入大于零的正整数或(1,2)位小数！"})},changeAdvanceSum:function(t){null!=t&&t.trim().length>0&&!this.isNumberByValue(t.trim())&&this.checkNumber(t,"预付款")},addProduct:function(){var t=this;this.$refs.orderAddDialog.getData(),this.dialogData.data=this.orderDtlList,this.dialogData.isNeedRepeat=!1,this.dialogData.title="选择货品",this.openDialogName="productTableDialog",this.$refs.submitForm.validate(function(e){e&&(t.showDialog=!0,t.inLinVisible=!0)})},setProductPrice:function(t,e){null!=t&&null!=e&&(null!=t.id&&(e.priceUnit=t.id),null!=t.productPrice&&(e.productPrice=t.productPrice),null!=t.n2pFormula&&(e.n2pFormula=t.n2pFormula),null!=t.p2nFormula&&(e.p2nFormula=t.p2nFormula))},formulaReckonByProductCount_n2p:function(t,e){if(null!=t&&0!=t.trim().length){var i="";null!=e.stockCount&&e.stockCount.trim().length>0&&(i=e.stockCount.trim());var a="";null!=e.productStockCount&&e.productStockCount.trim().length>0&&(a=e.productStockCount.trim()),Object(r.formulaReckonByProductCount)({parmKey:"N",stockCount:i,productStockCount:a,formula:t}).then(function(t){0===t.code&&(i-0!=0&&null!=t.stockCount_n2p&&t.stockCount_n2p.trim().length>0&&(e.stockCountByPrice=t.stockCount_n2p),a-0!=0&&null!=t.productStockCount_n2p&&t.productStockCount_n2p.trim().length>0&&(e.productStockCountByPrice=t.productStockCount_n2p))}).catch(function(t){})}},setProductSum:function(t){if(null!=t){t.productSum="";var e=t.count,i=t.productPrice;null!=e&&e.trim().length>0&&null!=i&&i.trim().length>0&&(t.productSum=(e.trim()*i.trim()).toFixed(2))}},dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},closeDialog:function(t){this.showDialog=!1;var e=!1;null!=t.isConfirm&&(e=t.isConfirm);var i=[];null!=t.selectList&&(i=t.selectList),this.tableSelected(e,i)},tableSelected:function(t,e){if(t&&null!=e&&e.length>0)for(var i=this.temp.expectDate,a=0;a<e.length;a++){var n=e[a],o={productId:"",productCode:"",productName:"",productSpec:"",productGenreName:"",productPrice:"",n2pFormula:"",p2nFormula:"",productUnit:"",productUnitName:"",productCount:"",stockCount:"",productStockCount:"",priceUnit:"",stockCountByPrice:"",productStockCountByPrice:"",count:"",productSum:"",deliverDate:"",stateName:"",remark:""};null!=n.code&&n.code.trim().length>0&&(o.productCode=n.code.trim()),null!=n.name&&n.name.trim().length>0&&(o.productName=n.name.trim()),null!=n.spec&&n.spec.trim().length>0&&(o.productSpec=n.spec.trim()),null!=n.genreName&&n.genreName.trim().length>0&&(o.productGenreName=n.genreName.trim()),null!=n.unitName&&n.unitName.trim().length>0&&(o.productUnitName=n.unitName.trim()),o.productId=n.id.trim(),o.productUnit=n.unit.trim(),o.stockCount=n.stockCount.trim(),o.productStockCount=n.productStockCount.trim(),null!=i&&(o.deliverDate=i,o.maxExpectDate=i,this.tempData.maxExpectDate=i);var l=this.temp.customerId;null!=l&&l.trim().length>0&&null!=n.id&&n.id.trim().length>0&&null!=n.unit&&n.unit.trim().length>0&&this.findProductPrice(o,l,n.id.trim(),n.unit.trim()),this.tableData.push(o)}},findProductPrice:function(t,e,i,a){return Object(l.a)({customerId:e,productId:i,unit:a}).then(function(e){0===e.code&&null!=e.productPrice&&e.productPrice.trim().length>0&&(t.productPrice=e.productPrice)}).catch(function(t){}),""}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},watch:{"temp.expectDate":function(){this.tempData.maxExpectDate=this.temp.expectDate}}},c=i("KHd+"),u=Object(c.a)(s,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"客户名称:",prop:"customerName"}},[i("base-input-option",{staticStyle:{width:"230px"},attrs:{dialog:t.CustomerDialog.dialog},on:{callback:t.customerSelect},model:{value:t.temp.customerName,callback:function(e){t.$set(t.temp,"customerName",e)},expression:"temp.customerName"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"发票类型:",prop:"receiptTypeName"}},[i("el-select",{staticStyle:{width:"230px"},attrs:{placeholder:"发票类型"},model:{value:t.temp.receiptType,callback:function(e){t.$set(t.temp,"receiptType",e)},expression:"temp.receiptType"}},[i("el-option",{attrs:{label:"不开票",value:"1"}}),t._v(" "),i("el-option",{attrs:{label:"普票发票",value:"2"}}),t._v(" "),i("el-option",{attrs:{label:"增值税发票",value:"3"}})],1)],1)],1),t._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"制单人:",prop:"makeName"}},[i("base-input-option",{staticStyle:{width:"230px"},attrs:{dialog:t.MakeDialog.dialog},on:{callback:t.makeSelect},model:{value:t.temp.makeName,callback:function(e){t.$set(t.temp,"makeName",e)},expression:"temp.makeName"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"下单日期:",prop:"orderDate"}},[i("el-date-picker",{staticStyle:{width:"230px"},attrs:{type:"date",placeholder:"下单日期","value-format":"yyyy-MM-dd"},model:{value:t.temp.orderDate,callback:function(e){t.$set(t.temp,"orderDate",e)},expression:"temp.orderDate"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"约定交期:",prop:"expectDate"}},[i("el-date-picker",{staticStyle:{width:"230px"},attrs:{type:"date",placeholder:"约定交期","value-format":"yyyy-MM-dd"},model:{value:t.temp.expectDate,callback:function(e){t.$set(t.temp,"expectDate",e)},expression:"temp.expectDate"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"预付款:",prop:"advanceSum"}},[i("el-input",{staticStyle:{width:"230px"},on:{change:t.changeAdvanceSum},model:{value:t.temp.advanceSum,callback:function(e){t.$set(t.temp,"advanceSum",e)},expression:"temp.advanceSum"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[i("el-input",{staticStyle:{width:"230px"},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:8}}),t._v(" "),i("el-col",{attrs:{span:8}})],1),t._v(" "),i("el-row",{staticStyle:{"margin-left":"2%","margin-bottom":"10px"}},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2),t._v(" "),i("el-row",{staticClass:"tableContent",staticStyle:{height:"450px",width:"96%","margin-left":"2%"}},[i("custom-base-table",{ref:"orderAddDialog",attrs:{isSortable:!1,varList:t.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:t.customColumn,apiObj:t.apiObj,mergeTitle:t.mergeTitle,mergeColumn:t.mergeColumn,mergeRow:t.mergeRow,tempData:t.tempData,componentId:"orderAddDialog",useDefaultBtn:!0,showAll:!1,keyMapping:t.keyMapping},on:{databridge:t.databridge}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);u.options.__file="dialogAdd.vue";e.default=u.exports},br4E:function(t,e,i){},lZYi:function(t,e,i){"use strict";var a=i("wnxv");i.n(a).a},qG3H:function(t,e,i){"use strict";var a=i("qltN");i.n(a).a},qltN:function(t,e,i){},wnxv:function(t,e,i){},zDZ1:function(t,e,i){"use strict";i("rE2o"),i("ioFf"),i("f3/d"),i("9WTv");function a(t){return(a="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={name:"dialog-add",props:["initData","visible"],components:{},data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},tempShow:{},rules:{},imageUrl:""}},created:function(){this.initData.temp&&(this.temp=this.initData.temp,this.initData.temp.qrcode&&(this.imageUrl="http://116.196.105.79:8080/"+this.initData.temp.qrcode)),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=a(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},download:function(){var t=this.imageUrl,e=document.createElement("a");e.style.display="none",e.href=t,e.setAttribute("download",this.temp.name),document.body.appendChild(e),e.click()},print:function(){var t=document.getElementById("printContent").innerHTML,e=document.body.innerHTML;return document.body.innerHTML=t,window.print(),window.location.reload(),document.body.innerHTML=e,!1}}},o=(i("lZYi"),i("qG3H"),i("KHd+")),l=Object(o.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"二维码",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("div",{attrs:{id:"printContent"}},[i("el-form",{ref:"submitForm",staticStyle:{width:"400px",margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{staticStyle:{"text-align":"center","padding-bottom":"20px"},attrs:{span:24}},[t.imageUrl?i("img",{staticClass:"avatar",staticStyle:{margin:"0 auto"},attrs:{src:t.imageUrl}}):i("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:24}},[i("b",{staticStyle:{"padding-left":"35%"}},[t._v(t._s(t.tempLable.code)+":")]),t._v(t._s(t.temp.code)),i("br"),t._v(" "),i("b",{staticStyle:{"padding-left":"35%"}},[t._v(t._s(t.tempLable.name)+":")]),t._v(t._s(t.temp.name)+"\n\n          ")])],1)],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center",padding:"15px 0 15px 0"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.download}},[t._v("下载")]),t._v(" "),i("el-button",{attrs:{type:"primary"},on:{click:t.print}},[t._v("打印")])],1)])])},[],!1,null,"56ed280a",null);l.options.__file="dialogQrcode.vue";e.a=l.exports}}]);