(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-c285","chunk-1b58","chunk-4eb7","chunk-7c77"],{"4Rkp":function(t,e,i){"use strict";var a=i("fmIS");i.n(a).a},BESt:function(t,e,i){"use strict";i.r(e);var a=i("2+ib"),o=i("cTe8"),n=(i("z0WU"),{components:{multilevelTable:a.a},name:"dialog-add",props:["initData","visible"],data:function(){return{rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{remark:"齐套分析预采",makeId:""},tempLable:{},tempQuery:{},rowData:{},selectList:[],configs:{topBarBtnList:[]},tempData:{defaultDate:new Date},tableConfigList:[{customColumn:[{columnIndex:"lackCount",width:120,componentName:"input",_cellConfig:{rules:[]}},{columnIndex:"edate",width:180,componentName:"date",_cellConfig:{valueType:"date",format:"yyyy-MM-dd",valueFormat:"yyyy-MM-dd",greaterThan:["self@cdate",!0]}},{columnIndex:"remark",width:120,componentName:"input",_cellConfig:{rules:[]}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"删除",nameEn:"deleteData",editBtns_isShow:!0,icon:"deleteData",method:this.deleteData}]}],apiObj:{apiName:"getLackProduct",params:{fieldCode:"code,name,spec,unit,lackCount,edate,remark",dtlJsonStr:this.initData.temp}},showIndex:!0,showCheckBox:!1,expand:!1,expandMode:"none",rowStyle:{"background-color":"#E4F3FA"}}]}},created:function(){var t=this.$storage.get("userInfo");this.temp.makeId=t.userId},mounted:function(){this.isVisible=this.visible},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getData:function(){this.$refs.customBaseTable.getData()},pushData:function(t,e){this.$refs.customBaseTable.pushData(t,e)},updateData:function(t){this.$refs.customBaseTable.updateData(t)},deleteData:function(t){this.$refs.customBaseTable.deleteData(t)},databridge:function(t){Array.isArray(t)?(this.selectList=[],this.selectList=t):(this.rowData=null,null!=t.row&&(this.rowData=t.row))},dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},saveOrder:function(){var t=this,e="",i="";if(this.getData(),null!=this.selectList&&0!=this.selectList.length){for(var a=[],n=0;n<this.selectList.length;n++){var l=this.selectList[n],s={productId:"",count:"",reason:"",edate:"",remark:"",id:""};s.productId=l.id,s.count=l.lackCount,s.remark=l.remark,s.edate=l.edate,s.reason="350135d34d1b43aeb4e2977061632045",s.id=l.id,i=i?i+",'"+l.id+"'":"'"+l.id+"'",a.push(s)}e=JSON.stringify(a),this.temp.prodIds=i,this.temp.dtlJsonStr=e,this.$refs.submitForm.validate(function(e){e&&Object(o.checkPurchasePlan)(t.temp).then(function(e){0===e.code&&(e.msg?t.$confirm(e.msg,"提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.addPurchasePlan(t.temp)}):t.addPurchasePlan(t.temp))}).catch(function(t){console.log(t)})})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一样货品！"})},addPurchasePlan:function(t){var e=this;this.dialogLoading=!0,Object(o.addPurchasePlan)(t).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){e.dialogLoading=!1,console.log(t)})},closeDialog:function(t){this.showDialog=!1;null!=t.isConfirm&&t.isConfirm;null!=t.selectList&&t.selectList}},watch:{}}),l=(i("WqLC"),i("KHd+")),s=Object(l.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1024px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[i("el-row",{staticStyle:{width:"96%","margin-left":"2%"}},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:t.tableConfigList},on:{databridge:t.databridge}})],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.saveOrder}},[t._v("生成采购计划")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);s.options.__file="dialogReport.vue";e.default=s.exports},DJRg:function(t,e,i){"use strict";i.r(e);var a=i("2+ib"),o=(i("z0WU"),i("Ppn9")),n={name:"dialog-option",props:["initData","visible"],data:function(){return{dialogTopLoading:!1,isVisible:!1,title:"",userInfo:null,tableConfigList:[{customColumn:[{columnIndex:"name","min-width":160,_cellConfig:{hideTitle:!0,bodyStyle:{color:"#199ED4","font-weight":600,width:"100%"},events:{type:"file",path:"url"}}},{columnIndex:"relativeUrl","min-width":250,_cellConfig:{hideTitle:!0}},{columnIndex:"cdate","min-width":120,_cellConfig:{hideTitle:!0}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"删除",nameEn:"delete",editBtns_isShow:!0,icon:"delete",method:this.delete}]}],apiObj:{apiName:"listPageBoms",params:{modelCode:"BomProduct",isdefault:"1",isdisable:"1"}},temp:{},showIndex:!0,showHeader:!0,showCheckBox:!0,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!1,expandMode:"none",showExpandBtn:!0,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}}],selectList:[],openDialogName:"",showDialog:!1,visibleState:!1,dialogData:{title:"",temp:null,tempLable:null}}},components:{multilevelTable:a.a},beforeCreate:function(){},created:function(){this.title=this.initData.title,this.userInfo=this.$storage.get("userInfo")},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{dialogClose:function(){this.$emit("close-dialog",{resState:"ok",selectList:[]})},addProduct:function(){this.selectList.length>0?this.$emit("close-dialog",{resState:"ok",selectList:this.selectList}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条记录！"})},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(t,e){this.$refs.customBaseTable.pushData(t,e)},updateData:function(t){this.selectList=[],this.$refs.customBaseTable.updateData(t)},deleteData:function(t){this.$refs.customBaseTable.deleteData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},delete:function(t,e){var i=this;i.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(o.deleteAttachment)(t).then(function(t){0===t.code&&(i.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),i.updateData())}).catch(function(t){console.log(t)})}).catch(function(){i.$message({type:"info",message:"已取消删除"})})},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.updateData()},databridge:function(t){this.selectList=t}},computed:{dialogName:function(){return this.openDialogName}},watch:{}},l=(i("OkRj"),i("KHd+")),s=Object(l.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.title,visible:t.isVisible,"append-to-body":"",width:"900px"},on:{"update:visible":function(e){t.isVisible=e},close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visibleState},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogTopLoading,expression:"dialogTopLoading"}]},[i("div",{staticStyle:{padding:"7px"}},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.addProduct}},[t._v("确定")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)])],1)},[],!1,null,null,null);s.options.__file="dialogAddProduct.vue";e.default=s.exports},LRVY:function(t,e,i){},OkRj:function(t,e,i){"use strict";var a=i("LRVY");i.n(a).a},QJ8N:function(t,e,i){"use strict";i.r(e);var a=i("2+ib"),o=i("DJRg"),n=i("Ti1M"),l=(i("z0WU"),i("Ppn9"),{name:"dialog-option",props:["initData","visible"],data:function(){return{dialogTopLoading:!1,isVisible:!1,title:"",userInfo:null,topBarBtnList:[{name:"添加产品",nameEn:"addProduct",isShow:!0,icon:"add",method:this.addProduct}],tempCount:{count:0},tableConfigList:[{customColumn:[{columnIndex:"planCount",componentName:"input",_cellConfig:{rules:[{required:!0},{greaterThan:["tempCount@count",!1]}],message:["该项不能为空！","该项输入必须大于零！"]}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"删除",nameEn:"delete",editBtns_isShow:!0,icon:"delete",method:this.delete}]}],apiObj:{apiName:"listPageBoms",params:{fieldCode:"prodCode,prodName,prodSpec,genreName,unitName,planCount",modelCode:"BomProduct",bomIds:this.initData.temp}},temp:{},showIndex:!0,showHeader:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,dragTable:!0,componentId:"oneLevelTable",expand:!1,expandMode:"none",showExpandBtn:!0,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}}],selectList:[],openDialogName:"",showDialog:!1,visibleState:!1,dialogData:{title:"",temp:null,tempLable:null}}},components:{multilevelTable:a.a,dialogAddProduct:o.default,dialogProdLackNum:n.default},beforeCreate:function(){},created:function(){this.title=this.initData.title,this.userInfo=this.$storage.get("userInfo")},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{dialogClose:function(){this.$emit("close-dialog",{resState:"ok"})},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(t,e){this.$refs.customBaseTable.pushData(t,e)},updateData:function(t){this.selectList=[],this.$refs.customBaseTable.updateData(t)},deleteData:function(t){this.$refs.customBaseTable.deleteData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},delete:function(t,e){var i=this,a=this;a.$confirm("此操作将删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){i.deleteData(t)}).catch(function(){a.$message({type:"info",message:"已取消删除"})})},nextStep:function(){this.getData(),0!=this.selectList.length&&(this.dialogData.temp=JSON.stringify(this.selectList),this.dialogData.tempLable=this.tempLable,this.dialogData.title="最大可生产量",this.openDialogName="dialogProdLackNum",this.showDialog=!0,this.visibleState=!0)},addProduct:function(){this.dialogData.temp=this.initData.temp,this.dialogData.title="添加产品",this.openDialogName="dialogAddProduct",this.showDialog=!0,this.visibleState=!0},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&(t.selectList?t.selectList.length>0&&this.pushData(t.selectList):this.dialogClose())},databridge:function(t){this.selectList=t}},computed:{dialogName:function(){return this.openDialogName}},watch:{}}),s=(i("4Rkp"),i("KHd+")),d=Object(s.a)(l,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.title,visible:t.isVisible,"append-to-body":"",width:"900px"},on:{"update:visible":function(e){t.isVisible=e},close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visibleState},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogTopLoading,expression:"dialogTopLoading"}]},[t.topBarBtnList&&t.topBarBtnList.length?i("div",{staticStyle:{height:"50px","box-sizing":"border-box",padding:"7px 20px 7px 7px"}},[t._l(t.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2):t._e(),t._v(" "),i("div",{staticStyle:{padding:"7px"}},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.nextStep}},[t._v("下一步")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)])],1)},[],!1,null,null,null);d.options.__file="dialogInputProdNum.vue";e.default=d.exports},Ti1M:function(t,e,i){"use strict";i.r(e);i("rGqo");var a=i("2+ib"),o=i("BESt"),n=(i("z0WU"),i("Ppn9"),{name:"dialog-option",props:["initData","visible"],data:function(){return{dialogTopLoading:!1,isVisible:!1,title:"",userInfo:null,topBarBtnList:[],tempCount:{count:0},tableConfigList:[{customColumn:[],apiObj:{apiName:"listProdLackNum",params:{dtlJsonStr:this.initData.temp,fieldCode:"code,name,spec,genre,unit,planCount,stockCount,assembledCount,maxCount,lackCount"}},temp:{},showIndex:!0,showHeader:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!1,expandMode:"none",showExpandBtn:!0,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}}],selectList:[],openDialogName:"",showDialog:!1,visibleState:!1,dialogData:{title:"",temp:null,tempLable:null}}},components:{multilevelTable:a.a,dialogReport:o.default},beforeCreate:function(){},created:function(){this.title=this.initData.title,this.userInfo=this.$storage.get("userInfo")},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{dialogClose:function(){this.$emit("close-dialog",{resState:"ok"})},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(t,e){this.$refs.customBaseTable.pushData(t,e)},updateData:function(t){this.selectList=[],this.$refs.customBaseTable.updateData(t)},deleteData:function(t){this.$refs.customBaseTable.deleteData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},delete:function(t,e){var i=this,a=this;a.$confirm("此操作将删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){i.deleteData(t)}).catch(function(){a.$message({type:"info",message:"已取消删除"})})},nextStep:function(){var t=this;if(this.getData(),0!=this.selectList.length){var e=0;this.selectList.forEach(function(i){if(e+=i.lackCount,i.lackCount>0)return t.dialogData.temp=JSON.stringify(t.selectList),t.dialogData.tempLable=t.tempLable,t.dialogData.title="分析结果",t.openDialogName="dialogReport",t.showDialog=!0,void(t.visibleState=!0)}),0!=e||this.$message({type:"warning",duration:5e3,showClose:!0,message:"物料充足，无需采购！"})}},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.dialogClose()},databridge:function(t){this.selectList=t}},computed:{dialogName:function(){return this.openDialogName}},watch:{}}),l=(i("zNZ+"),i("KHd+")),s=Object(l.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.title,visible:t.isVisible,"append-to-body":"",width:"1024px"},on:{"update:visible":function(e){t.isVisible=e},close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visibleState},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogTopLoading,expression:"dialogTopLoading"}]},[i("div",{staticStyle:{padding:"7px"}},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.nextStep}},[t._v("下一步")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)])],1)},[],!1,null,null,null);s.options.__file="dialogProdLackNum.vue";e.default=s.exports},WqLC:function(t,e,i){"use strict";var a=i("mBQz");i.n(a).a},XqKt:function(t,e,i){},fmIS:function(t,e,i){},mBQz:function(t,e,i){},"zNZ+":function(t,e,i){"use strict";var a=i("XqKt");i.n(a).a}}]);