(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-7bca","TFY4","mkwT"],{TFY4:function(e,t,a){"use strict";a.r(t);a("f3/d");var i=a("WIyV"),o=a("63W0");function n(e,t,a){return t in e?Object.defineProperty(e,t,{value:a,enumerable:!0,configurable:!0,writable:!0}):e[t]=a,e}var l={components:{customBaseTable:i.a},props:["initData","visible"],data:function(){return{modeId:"",eqptTableData:[],openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null},dialogLoading:!0,isVisible:!1,inDialog:!0,tableData:[],dataList:[],apiObj:{apiName:"listPageEquipmentMaintainPlan",params:{type:"add",fieldCode:"code,name,spec,maintainContent,maintainDateStr"}},customColumn:[],mergeTitle:[],mergeColumn:[],mergeRow:[],keyMapping:{},tempData:{maxExpectDate:""},isValidate:!1}},beforeCreate:function(){},created:function(){this.modeId=this.initData.modeId},beforeMount:function(){},mounted:function(){var e=this;this.dialogLoading=!1,this.isVisible=this.visible,this.$nextTick(function(t){e.eqptTableData=e.initData.eqptTableData,e.addTableDataByEquipment(e.eqptTableData)})},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(e){Array.isArray(e)&&(this.dataList=[],this.dataList=e)},save:function(){this.$refs.orderAddDialog.getData(),this.saveMaintainPlan(this.dataList)},saveMaintainPlan:function(e){var t=this;if(null!=e&&0!=e.length){for(var a=[],i=0;i<e.length;i++){var l,s=e[i],r=(n(l={equipmentId:s.equipmentId,maintainContentId:s.maintainContentId},"maintainContentId","e9e972fa916c4b9d8b81c2761a2cfb4d"),n(l,"isStop","1"),n(l,"maintainDateStr",s.maintainDateStr),l);a.push(r)}var d="";null!=a&&a.length>0&&(d=JSON.stringify(a)),this.dialogLoading=!0,Object(o.addMaintainPlanByCustom)({modeId:this.modeId,eqptJsonStr:d}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一样设备！"})},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",e||{})},closeDialog:function(e){},addTableDataByEquipment:function(e){for(var t=0;t<e.length;t++){var a=e[t],i={equipmentId:a.id,code:a.code,name:a.name,spec:a.spec};this.tableData.push(i),console.log(this.tableData,"this.tableData")}}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName},size:function(){return this.$store.getters.size},formItemWidth:function(){var e={};switch(this.size){case"mini":e.width="180px";break;case"small":e.width="200px";break;default:e.width="220px"}return e}},watch:{}},s=a("KHd+"),r=Object(s.a)(l,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[a("el-row",{staticClass:"tableContent",staticStyle:{width:"96%","margin-left":"2%"}},[a("custom-base-table",{ref:"orderAddDialog",attrs:{isSortable:!1,varList:e.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,tempData:e.tempData,componentId:"orderAddDialog",useDefaultBtn:!0,showAll:!1,keyMapping:e.keyMapping},on:{databridge:e.databridge}})],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);r.options.__file="addCustom.vue";t.default=r.exports},hgz3:function(e,t,a){"use strict";a.r(t);a("rE2o"),a("ioFf");var i=a("mkwT"),o=a("TFY4");function n(e){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var l={components:{addPeriod:i.default,addCustom:o.default},name:"dialog-add",props:["initData","visible"],data:function(){return{eqptTableData:[],modeId:"ee66976e1b3d453bae8839e6e9458b2f",dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{dialog_width:"",table_style:"",equipmentId:"",title:"",fullscreen:!1}}},created:function(){this.eqptTableData=this.initData.eqptTableData},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=n(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},radioChange:function(){},toNextPage:function(){"ee66976e1b3d453bae8839e6e9458b2f"==this.modeId?(this.dialogData.modeId=this.modeId,this.dialogData.eqptTableData=this.eqptTableData,this.dialogData.title="设定保养日期",this.openDialogName="addCustom",this.showDialog=!0,this.inLinVisible=!0):"9a05a30aa81e4637b498703b14cde8b1"==this.modeId&&(this.dialogData.modeId=this.modeId,this.dialogData.eqptTableData=this.eqptTableData,this.dialogData.title="设定周期",this.openDialogName="addPeriod",this.showDialog=!0,this.inLinVisible=!0)},closeDialog:function(e){this.dialogClose(e),this.showDialog=!1,this.isVisible=!1}}},s=a("KHd+"),r=Object(s.a)(l,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"新增",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"300px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",attrs:{model:e.formData,"label-position":"right","label-width":"120px"}},[a("el-row",{staticStyle:{margin:"10px 100px"}},[a("el-radio-group",{on:{change:e.radioChange},model:{value:e.modeId,callback:function(t){e.modeId=t},expression:"modeId"}},[e._v("\n          //设备保养方式: 7ef6384e92a343ccb839112a5d59b2fe (vmes_dictionary.id)\n          //ee66976e1b3d453bae8839e6e9458b2f 自定义\n          //9a05a30aa81e4637b498703b14cde8b1 按周期\n          "),a("el-radio",{attrs:{label:"ee66976e1b3d453bae8839e6e9458b2f"}},[e._v("自定义")]),a("br"),e._v(" "),a("el-radio",{attrs:{label:"9a05a30aa81e4637b498703b14cde8b1"}},[e._v("按周期")]),a("br")],1)],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.toNextPage}},[e._v("下一步")]),e._v(" "),a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);r.options.__file="selectMode.vue";t.default=r.exports},mkwT:function(e,t,a){"use strict";a.r(t);a("rE2o"),a("ioFf");var i=a("63W0");function o(e){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var n={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{eqptTableData:[],dateArray:[],sysPeriodTypeOption:[],dayOfWeekOption:[],dayOfMonthOption:[],isShowCustomPeriod:!1,isShowDayOfWeek:!1,isShowDayOfMonth:!1,rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:""},dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{id:"",modeId:"",beginPlan:"",endPlan:"",sysPeriodType:"",periodCount:"",periodType:"",periodDayofweek:"",periodDayofmonth:"",eqptJsonStr:""}}},created:function(){this.formData.modeId=this.initData.modeId,this.eqptTableData=this.initData.eqptTableData,this.initialDayOfWeekOption(),this.initialDayOfMonthOption()},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=o(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dataBridge:function(e){},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},deleteBtns:function(e,t){this.tableData.splice(t,1)},closeDialog:function(e){},initialDayOfWeekOption:function(){for(var e=1;e<=7;e++)if(1==e){this.dayOfWeekOption.push({label:"星期一",value:"MONDAY"})}else if(2==e){this.dayOfWeekOption.push({label:"星期二",value:"TUESDAY"})}else if(3==e){this.dayOfWeekOption.push({label:"星期三",value:"WEDNESDAY"})}else if(4==e){this.dayOfWeekOption.push({label:"星期四",value:"THURSDAY"})}else if(5==e){this.dayOfWeekOption.push({label:"星期五",value:"FRIDAY"})}else if(6==e){this.dayOfWeekOption.push({label:"星期六",value:"SATURDAY"})}else if(7==e){this.dayOfWeekOption.push({label:"星期日",value:"SUNDAY"})}},initialDayOfMonthOption:function(){for(var e=1;e<=31;e++){var t=e+"";1==t.trim().length&&(t="0"+t);var a={label:t,value:t};this.dayOfMonthOption.push(a)}},beginEndPlanChange:function(){null!=this.dateArray&&2==this.dateArray.length&&(this.sysPeriodTypeOption=[{label:"每天",value:"everDay"},{label:"每周星期几",value:"dayOfWeek"},{label:"每月第几个星期几",value:"weekOfMonth"},{label:"每年某月某日",value:"dayOfYear"},{label:"工作日[周1-周5]",value:"workDay"},{label:"自定义周期",value:"customPeriod"}])},sysPeriodTypeChange:function(e){this.formData.periodCount="",this.formData.periodType="",this.formData.periodDayofweek="",this.formData.periodDayofmonth="",this.isShowCustomPeriod=!1,this.isShowDayOfWeek=!1,this.isShowDayOfMonth=!1,"customPeriod"==e&&(this.isShowCustomPeriod=!0)},sysPeriodTypeFocus:function(e){null!=this.dateArray&&2==this.dateArray.length||this.$message({type:"warning",duration:5e3,showClose:!0,message:"请选择完整的计划起止日期"})},periodTypeChange:function(e){this.formData.periodDayofweek="",this.formData.periodDayofmonth="",this.isShowDayOfWeek=!1,this.isShowDayOfMonth=!1,"week"==e?this.isShowDayOfWeek=!0:"month"==e&&(this.isShowDayOfMonth=!0)},save:function(){var e=this;null!=this.dateArray&&2==this.dateArray.length||this.$message({type:"warning",duration:5e3,showClose:!0,message:"请选择完整的计划起止日期"}),this.formData.beginPlan=this.dateArray[0],this.formData.endPlan=this.dateArray[1];var t=[];if(null!=this.eqptTableData&&this.eqptTableData.length>0)for(var a=0;a<this.eqptTableData.length;a++){var o={equipmentId:this.eqptTableData[a].id,maintainContentId:"e9e972fa916c4b9d8b81c2761a2cfb4d",isStop:"1"};t.push(o)}var n="";null!=t&&t.length>0&&(n=JSON.stringify(t)),this.formData.eqptJsonStr=n,this.$refs.submitForm.validate(function(t){t&&Object(i.addMaintainPlan)(e.formData).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(e){})})}},watch:{}},l=a("KHd+"),s=Object(l.a)(n,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"500px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{margin:"10px auto",width:"100%"}},[a("el-form",{ref:"submitForm",attrs:{rules:e.rules,model:e.formData,"label-position":"right","label-width":"120px"}},[a("el-row",[a("el-form-item",{attrs:{label:"计划起止日期:"}},[a("el-date-picker",{attrs:{"value-format":"yyyy-MM-dd",type:"daterange","range-separator":"--","start-placeholder":"开始日期","end-placeholder":"结束日期"},on:{change:e.beginEndPlanChange},model:{value:e.dateArray,callback:function(t){e.dateArray=t},expression:"dateArray"}})],1)],1),e._v(" "),a("el-row",[a("el-form-item",{attrs:{label:"系统匹配周期:"}},[a("el-select",{staticStyle:{width:"350px"},attrs:{placeholder:""},on:{change:e.sysPeriodTypeChange,focus:e.sysPeriodTypeFocus},model:{value:e.formData.sysPeriodType,callback:function(t){e.$set(e.formData,"sysPeriodType",t)},expression:"formData.sysPeriodType"}},e._l(e.sysPeriodTypeOption,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1)],1)],1),e._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:e.isShowCustomPeriod,expression:"isShowCustomPeriod"}]},[a("el-row",[a("el-form-item",{attrs:{label:"重复频率:"}},[e._v("\n            每 "),a("el-input-number",{staticStyle:{width:"130px"},attrs:{min:1,max:99999},model:{value:e.formData.periodCount,callback:function(t){e.$set(e.formData,"periodCount",t)},expression:"formData.periodCount"}}),e._v(" "),a("el-select",{attrs:{placeholder:""},on:{change:e.periodTypeChange},model:{value:e.formData.periodType,callback:function(t){e.$set(e.formData,"periodType",t)},expression:"formData.periodType"}},[a("el-option",{attrs:{label:"周",value:"week"}}),e._v(" "),a("el-option",{attrs:{label:"月",value:"month"}})],1)],1)],1),e._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:e.isShowDayOfWeek,expression:"isShowDayOfWeek"}]},[a("el-row",[a("el-form-item",{attrs:{label:"重复时间(周):"}},[a("el-select",{staticStyle:{width:"350px"},attrs:{placeholder:""},model:{value:e.formData.periodDayofweek,callback:function(t){e.$set(e.formData,"periodDayofweek",t)},expression:"formData.periodDayofweek"}},e._l(e.dayOfWeekOption,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1)],1)],1)],1),e._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:e.isShowDayOfMonth,expression:"isShowDayOfMonth"}]},[a("el-row",[a("el-form-item",{attrs:{label:"重复时间(月):"}},[a("el-select",{staticStyle:{width:"350px"},attrs:{placeholder:""},model:{value:e.formData.periodDayofmonth,callback:function(t){e.$set(e.formData,"periodDayofmonth",t)},expression:"formData.periodDayofmonth"}},e._l(e.dayOfMonthOption,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1)],1)],1)],1)],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);s.options.__file="addPeriod.vue";t.default=s.exports}}]);