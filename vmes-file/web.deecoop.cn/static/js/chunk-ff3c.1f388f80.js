(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-ff3c"],{"6Xv9":function(t,i,e){},"98Ah":function(t,i,e){"use strict";var a=e("6Xv9");e.n(a).a},zoBp:function(t,i,e){"use strict";e.r(i);var a=e("nvec"),s=e("m2/r"),l=e("OVXg"),n=e("zBZs"),d=e("S2+0"),o=e("khHw"),r=(e("91GP"),e("xfY5"),e("i9cY")),u=e("z0WU"),h={name:"adaptive-text",props:{guid:{type:String,default:""},unit:{type:String,default:""},text:{type:String,default:""},textStyle:{type:Object,default:function(){return{}}},lastSize:{type:Number,default:0}},data:function(){return{resetOk:!1,boxWidth:0,textWidth:0,originFontSize:0,resetFontSize:0,componentId:"",baseStyle:{display:"inline-block",overflow:"hidden"},isEllipsis:!1,ellipsis:{textOverflow:"ellipsis",whiteSpace:"nowrap"}}},computed:{globalSize:function(){return this.guid?this.$store.getters[this.guid+"/size"]||{}:null},setMinSize:function(){if(console.log(this.globalSize,"setMinSize"),this.globalSize){var t=[];for(var i in this.globalSize)this.globalSize.hasOwnProperty(i)&&t.push(this.globalSize[i]);return Math.min.apply(Math,t)}return this.resetFontSize},setTextStyle:function(){return console.log(this.setMinSize,"setTextStyle"),this.setMinSize?Object.assign({},this.baseStyle,this.textStyle,{fontSize:"".concat(this.setMinSize-this.lastSize,"px")},this.isEllipsis?this.ellipsis:{},{maxWidth:"calc(100% - ".concat(this.unit?13:0,"px")}):this.textStyle}},methods:{resetTextFontSize:function(){if(this.originFontSize-=1,console.log(this.originFontSize),!(this.originFontSize>16))return this.resetFontSize=this.originFontSize=16,this.isEllipsis=!0,void(this.resetOk=!0);var t,i=JSON.parse(JSON.stringify(this.textStyle));for(var e in i)if(i.hasOwnProperty(e)&&("fontSize"===e||"font-size"===e)){delete i.fontSize,delete i["font-size"];break}if(i.fontSize=this.originFontSize+"px",t=Object(r.a)(this.text,i),!(this.boxWidth<t+(this.unit?13:0)))return this.resetFontSize=this.originFontSize,this.isEllipsis=!1,void(this.resetOk=!0);this.resetTextFontSize()}},watch:{resetFontSize:function(){if(this.guid){var t={};t[this.componentId]=this.resetFontSize,this.$store.commit(this.guid+"/SET_SIZE",t)}}},created:function(){this.guid&&(this.componentId=Object(u.a)()),this.text&&(this.textWidth=Object(r.a)(this.text,this.textStyle)),this.originFontSize=parseInt(this.textStyle.fontSize||this.textStyle["font-size"]||"0")},mounted:function(){this.boxWidth=this.$el.clientWidth,console.log(this.textWidth,this.boxWidth),this.boxWidth>=this.textWidth+(this.unit?13:0)?(this.resetFontSize=this.originFontSize,this.resetOk=!0):this.resetTextFontSize()},render:function(t){return t("div",{style:"display: inline-block;width: 100%;"},[this.resetOk?this.unit?t("div",[t("span",{style:this.setTextStyle,attrs:{title:this.isEllipsis?this.text:""}},[this.text]),t("span",{style:"font-size: 12px;display: inline-block;vertical-align: super;"},[this.unit])]):t("span",{style:this.setTextStyle,attrs:{title:this.isEllipsis?this.text:""}},[this.text]):null])}},v=e("WwWg"),c={name:"analysis-overview",components:{saleTrend:a.a,saleStaffTrend:s.a,saleReceivables:n.a,saleQuotaDistribution:d.a,saleCustomerQuotaDistribution:o.a,saleStaffRanking:l.a,adaptiveText:h},data:function(){return{guid:"",initLoading:!0,apiObj1:{apiName:"salesTrendQuery",params:{}},apiObj2:{apiName:"accountsReceivableQuery",params:{}},apiObj3:{apiName:"salesVolumeByProductQuery",params:{}},apiObj4:{apiName:"salesNumberByProductQuery",params:{}},apiObj5:{apiName:"productReturnRateQuery",params:{}},apiObj6:{apiName:"salesVolumeByCustomerQuery",params:{}},apiObj7:{apiName:"salesTrendByEmployeeQuery",params:{}},apiObj8:{apiName:"salesByEmployeeQuery",params:{}},result:{},salesVolume:{},salesVolumeState:{thisMonth:!1,lastMonth:!1,monthBefore:!1,thisYear:!1,lastYear:!1},salesVolumeWidth:{thisMonth:0,lastMonth:0,monthBefore:0,thisYear:0,lastYear:0},salesNum:{},salesNumState:{thisMonth:!1,lastMonth:!1,monthBefore:!1,thisYear:!1,lastYear:!1},floatList:[""]}},methods:{formatNumber:function(t){return(arguments.length>1&&void 0!==arguments[1]?arguments[1]:"")?t?(t-0).toFixed(2)+"":"0.00":t?t-0+"":"0"},httpRequest:function(){var t=this;this.initLoading=!0,this.$api.syntheticalQuery().then(function(i){t.result=i.result||{},t.initLoading=!1}).catch(function(i){t.initLoading=!1})}},computed:{setHeight:function(){return"400px"},userInfo:function(){return this.$store.getters.userInfo}},created:function(){this.guid=Object(u.a)(),Object(v.b)(this),this.httpRequest()},beforeDestroy:function(){Object(v.h)(this.$store,this.guid)}},p=(e("98Ah"),e("KHd+")),x=Object(p.a)(c,function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("div",{staticClass:"analysisOverview"},[e("div",{directives:[{name:"loading",rawName:"v-loading",value:t.initLoading,expression:"initLoading"}],staticClass:"dataPlan"},[e("div",{staticClass:"dataView"},[e("div",{staticClass:"viewTitle"},[t._v("销售额")]),t._v(" "),e("div",{staticClass:"dataBox clearfix"},[e("div",{staticClass:"dataBoxLeft"},[e("div",{staticClass:"dataTitle"},[t._v("本月")]),t._v(" "),e("div",{staticClass:"dataNumberBox"},[e("adaptive-text",{attrs:{guid:t.guid,unit:"元",text:t.formatNumber(t.result.salesVolumeMonth,"salesVolumeMonth"),textStyle:{fontSize:"24px",fontWeight:600}}})],1)]),t._v(" "),e("div",{staticClass:"dataBoxRight"},[e("div",{staticClass:"dataTitle"},[t._v("上月")]),t._v(" "),e("div",{staticClass:"dataNumberBox"},[e("adaptive-text",{attrs:{guid:t.guid,unit:"元",text:t.formatNumber(t.result.salesVolumeLastMonth,"salesVolumeLastMonth"),textStyle:{fontSize:"24px",fontWeight:600},lastSize:4}})],1),t._v(" "),e("div",{staticClass:"dataTitle paddingT10"},[t._v("同比")]),t._v(" "),e("div",{staticClass:"dataNumberBox"},[e("adaptive-text",{attrs:{guid:t.guid,unit:"元",text:t.formatNumber(t.result.salesVolumeYearOnYear,"salesVolumeYearOnYear"),textStyle:{fontSize:"24px",fontWeight:600},lastSize:4}})],1)])]),t._v(" "),e("div",{staticClass:"dataBox clearfix paddingT30"},[e("div",{staticClass:"dataBoxLeft"},[e("div",{staticClass:"dataTitle"},[t._v("今年")]),t._v(" "),e("div",{staticClass:"dataNumberBox"},[e("adaptive-text",{attrs:{guid:t.guid,unit:"元",text:t.formatNumber(t.result.salesVolumeYear,"salesVolumeYear"),textStyle:{fontSize:"24px",fontWeight:600}}})],1)]),t._v(" "),e("div",{staticClass:"dataBoxRight resetMargin paddingT10 paddingB10"},[e("div",{staticClass:"dataTitle"},[t._v("去年")]),t._v(" "),e("div",{staticClass:"dataNumberBox"},[e("adaptive-text",{attrs:{guid:t.guid,unit:"元",text:t.formatNumber(t.result.salesVolumeLastYear,"salesVolumeLastYear"),textStyle:{fontSize:"24px",fontWeight:600},lastSize:4}})],1)])])]),t._v(" "),e("div",{staticClass:"dataView"},[e("div",{staticClass:"viewTitle"},[t._v("销售量")]),t._v(" "),e("div",{staticClass:"dataBox clearfix"},[e("div",{staticClass:"dataBoxLeft"},[e("div",{staticClass:"dataTitle"},[t._v("本月")]),t._v(" "),e("div",{staticClass:"dataNumberBox"},[e("adaptive-text",{attrs:{guid:t.guid,text:t.formatNumber(t.result.salesNumberMonth),textStyle:{fontSize:"24px",fontWeight:600}}})],1)]),t._v(" "),e("div",{staticClass:"dataBoxRight"},[e("div",{staticClass:"dataTitle"},[t._v("上月")]),t._v(" "),e("div",{staticClass:"dataNumberBox"},[e("adaptive-text",{attrs:{guid:t.guid,text:t.formatNumber(t.result.salesNumberLastMonth),textStyle:{fontSize:"24px",fontWeight:600},lastSize:4}})],1),t._v(" "),e("div",{staticClass:"dataTitle paddingT10"},[t._v("同比")]),t._v(" "),e("div",{staticClass:"dataNumberBox"},[e("adaptive-text",{attrs:{guid:t.guid,text:t.formatNumber(t.result.salesNumberYearOnYear),textStyle:{fontSize:"24px",fontWeight:600},lastSize:4}})],1)])]),t._v(" "),e("div",{staticClass:"dataBox clearfix paddingT30"},[e("div",{staticClass:"dataBoxLeft"},[e("div",{staticClass:"dataTitle"},[t._v("今年")]),t._v(" "),e("div",{staticClass:"dataNumberBox"},[e("adaptive-text",{attrs:{guid:t.guid,text:t.formatNumber(t.result.salesNumberYear),textStyle:{fontSize:"24px",fontWeight:600}}})],1)]),t._v(" "),e("div",{staticClass:"dataBoxRight resetMargin paddingT10 paddingB10"},[e("div",{staticClass:"dataTitle"},[t._v("去年")]),t._v(" "),e("div",{staticClass:"dataNumberBox"},[e("adaptive-text",{attrs:{guid:t.guid,text:t.formatNumber(t.result.salesNumberLastYear),textStyle:{fontSize:"24px",fontWeight:600}}})],1)])])]),t._v(" "),e("div",{staticClass:"dataView"},[e("div",{staticClass:"dataBox clearfix paddingB30"},[e("div",{staticClass:"dataBoxLeft paddingB20",staticStyle:{"padding-top":"0"}},[e("div",{staticClass:"dataTitle",staticStyle:{visibility:"hidden"}},[t._v("本月")]),t._v(" "),e("div",{staticClass:"dataNumberBox"},[e("adaptive-text",{attrs:{guid:t.guid,unit:"元",text:t.formatNumber(t.result.accountsReceivable,"accountsReceivable"),textStyle:{fontSize:"24px",fontWeight:600}}})],1),t._v(" "),e("div",{staticClass:"dataBoxTitle"},[t._v("应收账款")])]),t._v(" "),e("div",{staticClass:"dataBoxRight paddingB20"},[e("div",{staticClass:"dataTitle",staticStyle:{visibility:"hidden"}},[t._v("本月")]),t._v(" "),e("div",{staticClass:"dataNumberBox"},[e("adaptive-text",{attrs:{guid:t.guid,unit:"元",text:t.formatNumber(t.result.accountsReceivableMonth,"accountsReceivableMonth"),textStyle:{fontSize:"24px",fontWeight:600}}})],1),t._v(" "),e("div",{staticClass:"dataBoxTitle"},[t._v("本月新增")])])]),t._v(" "),e("div",{staticClass:"dataBox clearfix",staticStyle:{"padding-top":"40px"}},[e("div",{staticClass:"dataBoxLeft paddingB20",staticStyle:{"padding-top":"0"}},[e("div",{staticClass:"dataTitle",staticStyle:{visibility:"hidden"}},[t._v("本月")]),t._v(" "),e("div",{staticClass:"dataNumberBox"},[e("adaptive-text",{attrs:{guid:t.guid,unit:"单",text:t.formatNumber(t.result.orderNumberMonth),textStyle:{fontSize:"24px",fontWeight:600}}})],1),t._v(" "),e("div",{staticClass:"dataBoxTitle"},[t._v("本月订单")])]),t._v(" "),e("div",{staticClass:"dataBoxRight paddingB20"},[e("div",{staticClass:"dataTitle",staticStyle:{visibility:"hidden"}},[t._v("本月")]),t._v(" "),e("div",{staticClass:"dataNumberBox"},[e("adaptive-text",{attrs:{guid:t.guid,unit:"单",text:t.formatNumber(t.result.orderNumberPending),textStyle:{fontSize:"24px",fontWeight:600}}})],1),t._v(" "),e("div",{staticClass:"dataBoxTitle"},[t._v("待完成")])])]),t._v(" "),e("div",{staticClass:"backgroundBar"})])]),t._v(" "),e("div",{staticClass:"chartsView"},[e("sale-trend",{attrs:{height:t.setHeight,apiObj:t.apiObj1}})],1),t._v(" "),e("div",{staticClass:"chartsView"},[e("sale-receivables",{attrs:{apiObj:t.apiObj2,height:t.setHeight}})],1),t._v(" "),e("div",{staticClass:"chartsView"},[e("sale-quota-distribution",{attrs:{height:t.setHeight,apiObj:t.apiObj3,title:"产品销售额分布",valueKey:"volume"}})],1),t._v(" "),e("div",{staticClass:"chartsView"},[e("sale-quota-distribution",{attrs:{height:t.setHeight,apiObj:t.apiObj4,title:"产品销量分布",dataTitle:"销售量",valueKey:"number"}})],1),t._v(" "),e("div",{staticClass:"chartsView"},[e("sale-quota-distribution",{attrs:{height:t.setHeight,apiObj:t.apiObj5,title:"产品退货分布",dataTitle:"退货量",valueKey:"number"}})],1),t._v(" "),e("div",{staticClass:"chartsView"},[e("sale-customer-quota-distribution",{attrs:{height:t.setHeight,apiObj:t.apiObj6}})],1),t._v(" "),e("div",{staticClass:"chartsView"},[e("sale-staff-ranking",{attrs:{height:t.setHeight,apiObj:t.apiObj8}})],1),t._v(" "),e("div",{staticClass:"chartsView"},[e("sale-staff-trend",{attrs:{height:t.setHeight,apiObj:t.apiObj7}})],1),t._v(" "),e("div",{staticClass:"chartsView"},[e("adaptive-text",{attrs:{guid:t.guid}})],1)])},[],!1,null,null,null);x.options.__file="index.vue";i.default=x.exports}}]);