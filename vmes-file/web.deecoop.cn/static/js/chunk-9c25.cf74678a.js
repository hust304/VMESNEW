(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-9c25"],{"4Cjf":function(t,e,a){"use strict";e.a={trend:{result:[{month:"2018-01",salesVolume:220,salesNumber:315},{month:"2018-02",salesVolume:20,salesNumber:25},{month:"2018-03",salesVolume:120,salesNumber:135},{month:"2018-04",salesVolume:220,salesNumber:315},{month:"2018-05",salesVolume:320,salesNumber:355},{month:"2018-06",salesVolume:350,salesNumber:415},{month:"2018-07",salesVolume:320,salesNumber:365},{month:"2018-08",salesVolume:420,salesNumber:515},{month:"2018-09",salesVolume:520,salesNumber:615},{month:"2018-10",salesVolume:220,salesNumber:315},{month:"2018-11",salesVolume:330,salesNumber:355},{month:"2018-12",salesVolume:220,salesNumber:315},{month:"2019-01",salesVolume:120,salesNumber:125},{month:"2019-02",salesVolume:110,salesNumber:115},{month:"2019-03",salesVolume:220,salesNumber:315},{month:"2019-04",salesVolume:420,salesNumber:445},{month:"2019-05",salesVolume:520,salesNumber:715},{month:"2019-06",salesVolume:550,salesNumber:730},{month:"2019-07",salesVolume:420,salesNumber:555},{month:"2019-08",salesVolume:590,salesNumber:795},{month:"2019-09",salesVolume:320,salesNumber:415},{month:"2019-10",salesVolume:420,salesNumber:625},{month:"2019-11",salesVolume:720,salesNumber:915},{month:"2019-12",salesVolume:620,salesNumber:825},{month:"2020-01",salesVolume:320,salesNumber:415},{month:"2020-02",salesVolume:220,salesNumber:315},{month:"2020-03",salesVolume:420,salesNumber:515},{month:"2020-04",salesVolume:520,salesNumber:715}]},receivables:{result:[{name:"公司1",proportion:1},{name:"公司2",proportion:2},{name:"公司3",proportion:3},{name:"公司4",proportion:4},{name:"公司5",proportion:5},{name:"公司6",proportion:6},{name:"公司7",proportion:7},{name:"公司888888888888888888",proportion:8},{name:"公司9",proportion:9},{name:"公司10",proportion:10},{name:"公司11",proportion:11},{name:"公司12",proportion:12},{name:"公司13",proportion:13},{name:"公司14",proportion:14},{name:"公司15",proportion:15}]}}},OVXg:function(t,e,a){"use strict";a("91GP");var n={titles:[{name:"姓名"},{id:"id"},{salesVolume:"销售额"},{salesNumber:"销售量"},{orderNumber:"订单数"}],hideTitles:["id"],varList:[],pageData:{current:1,pages:"1",records:[],size:10,total:"1"}},i=a("z0WU"),s=a("SeVM"),r=a("XXtD");a("zixQ"),e.a={name:"chart-sale-staff-ranking",components:{DatePicker:s.a,ChartMask:r.a},props:{height:{type:String,default:"300px"},width:{type:String,default:"100%"},apiObj:{type:Object,default:function(){return{}}}},data:function(){return{loading:!0,selectMonths:[],titleList:[],tableList:[]}},computed:{userInfo:function(){return this.$store.getters.userInfo},hasData:function(){return!!this.titleList.length},setParams:function(){return Object.assign({},this.apiObj.params,{startDate:this.selectMonths[0],endDate:this.selectMonths[1]})}},methods:{httpRequest:function(){var t=this;this.loading=!0,this.apiObj.apiName?this.$api[this.apiObj.apiName](this.setParams).then(function(e){t.titleList=Object(i.o)(n),t.tableList=e.result,t.loading=!1}).catch(function(e){t.loading=!1}):setTimeout(function(e){t.titleList=Object(i.o)(n),t.tableList=n.varList,t.loading=!1},3e3)},formatData:function(){},dateChange:function(t){this.selectMonths=t,this.tableList=[]},tableRowClassName:function(t){t.row;return t.rowIndex%2?"evenRow":"oddRow"}},watch:{selectMonths:function(){this.httpRequest()}},render:function(t){return t("div",{directives:[{name:"loading",value:this.loading}],class:"resetChartViewStyle",attrs:{"element-loading-text":"数据加载中...","element-loading-spinner":"none"},style:{height:this.height}},[t("date-picker",{on:{datechange:this.dateChange},attrs:{disabledDate:!0}}),this.hasData?t("div",[t("el-table",{ref:"chartTable",attrs:{data:this.tableList,stripe:!0,border:!0,"current-row-key":"id",height:"".concat(parseInt(this.height)-40,"px"),size:"mini",fit:!0,"row-key":"id","header-row-class-name":"chartTableHeaderClass"},style:"width: 100%;"},[this.titleList.map(function(e,a){return t("el-table-column",{attrs:{"show-overflow-tooltip":!0,sortable:!!a,label:e.label,prop:e.prop,align:"center"}})})])]):t("chart-Mask",{attrs:{loading:this.loading}})])}}},"S2+0":function(t,e,a){"use strict";a("f3/d"),a("91GP"),a("xfY5");var n=a("nKjl"),i=a("SeVM"),s=a("XXtD");a("wDdD"),a("sRwP"),a("0o9m"),a("C0tN"),a("AH3D"),a("Ynxi"),a("zixQ");e.a={name:"chart-sale-quota-distribution",components:{chart:n.a,DatePicker:i.a,ChartMask:s.a},props:{height:{type:String,default:"300px"},title:{type:String,default:""},dataTitle:{type:String,default:"销售额"},valueKey:{type:String,default:""},width:{type:String,default:"100%"},node:{type:Number,default:5},apiObj:{type:Object,default:function(){return{}}}},data:function(){return{loading:!0,chartData:null,selectMonths:[]}},computed:{setLegendData:function(){return this.chartData&&this.chartData.legendData||[]},setSeriesData:function(){return this.chartData&&this.chartData.seriesData||[]},hasData:function(){return!!this.setSeriesData.length},defaultOption:function(){return{title:{text:this.title,left:"center"},tooltip:{trigger:"item",formatter:"{a}: {b}<br/>"+this.dataTitle+": {c} ({d}%)"},legend:{type:"scroll",orient:"vertical",left:50,top:"middle",padding:[40,0],data:this.setLegendData,formatter:function(t){return"".concat(t.length>19?t.slice(0,20)+"... ":t)}},series:[{name:"产品",type:"pie",radius:"55%",center:["70%","50%"],data:this.setSeriesData,label:{show:!1},labelLine:{show:!1},emphasis:{itemStyle:{shadowBlur:10,shadowOffsetX:0,shadowColor:"rgba(0, 0, 0, 0.5)"}}}]}},userInfo:function(){return this.$store.getters.userInfo},setParams:function(){return Object.assign({},this.apiObj.params,{startDate:this.selectMonths[0],endDate:this.selectMonths[1]})}},watch:{selectMonths:function(t,e){this.httpRequest()}},methods:{formatChartData:function(t){var e=this;return t.length?{legendData:t.map(function(t){return t.name}),seriesData:t.map(function(t){return{name:t.name,value:t[e.valueKey]}})}:{}},dateChange:function(t){this.selectMonths=t},httpRequest:function(){var t=this;this.loading=!0,this.apiObj.apiName?this.$api[this.apiObj.apiName](this.setParams).then(function(e){t.chartData=t.formatChartData(e.result||[]),t.loading=!1}).catch(function(e){t.loading=!1}):setTimeout(function(e){t.chartData=t.genData(30),t.loading=!1},3e3)},genData:function(t){for(var e=["赵","钱","孙","李","周","吴","郑","王","冯","陈","褚","卫","蒋","沈","韩","杨","朱","秦","尤","许","何","吕","施","张","孔","曹","严","华","金","魏","陶","姜","戚","谢","邹","喻","柏","水","窦","章","云","苏","潘","葛","奚","范","彭","郎","鲁","韦","昌","马","苗","凤","花","方","俞","任","袁","柳","酆","鲍","史","唐","费","廉","岑","薛","雷","贺","倪","汤","滕","殷","罗","毕","郝","邬","安","常","乐","于","时","傅","皮","卞","齐","康","伍","余","元","卜","顾","孟","平","黄","和","穆","萧","尹","姚","邵","湛","汪","祁","毛","禹","狄","米","贝","明","臧","计","伏","成","戴","谈","宋","茅","庞","熊","纪","舒","屈","项","祝","董","梁","杜","阮","蓝","闵","席","季","麻","强","贾","路","娄","危"],a=[],n=[],i={},s=0;s<t;s++)name=Math.random()>.65?r(4,1)+"·"+r(3,0):r(2,1),a.push(name),n.push({name:name,value:Math.round(1e5*Math.random())}),i[name]=s<6;return{legendData:a,seriesData:n,selected:i};function r(t,a){for(var n=Math.ceil(Math.random()*t+a),i=[],s=0;s<n;s++)i.push(e[Math.round(Math.random()*e.length-1)]);return i.join("")}}},created:function(){},render:function(t){return t("div",{directives:[{name:"loading",value:this.loading}],class:"resetChartViewStyle",attrs:{"element-loading-text":"数据加载中...","element-loading-spinner":"none"},style:{height:this.height}},[t("date-picker",{on:{datechange:this.dateChange},attrs:{disabledDate:!0}}),this.hasData?t("div",[t("chart",{style:{height:"".concat(parseInt(this.height)-39,"px"),width:this.width},attrs:{options:this.defaultOption}})]):t("chart-Mask",{attrs:{loading:this.loading}})])}}},SeVM:function(t,e,a){"use strict";var n=a("TB3a");e.a={name:"charts-date-picker",props:{disabledDate:{type:Boolean,default:!1}},data:function(){return{defaultDate:[],editableState:!1,unlinkPanels:!0}},computed:{pickerOptions:function(){return this.disabledDate?{disabledDate:function(t){return t.getTime()>=(new Date).getTime()}}:{}}},methods:{datePickerChange:function(t){this.defaultDate=t,this.$emit("datechange",t)}},created:function(){this.defaultDate=[n.a.getMonth(null,null,12),n.a.getMonth()],this.$emit("datechange",this.defaultDate)},render:function(t){return t("div",{style:"margin-bottom:10px;"},[t("el-date-picker",{class:"resetChartDatePickerStyle",attrs:{type:"monthrange",value:this.defaultDate,"unlink-panels":this.unlinkPanels,size:"mini","start-placeholder":"开始月份","end-placeholder":"结束月份",format:"yyyy 年 MM 月","value-format":"yyyy-MM",editable:this.editableState,"picker-options":this.pickerOptions},on:{input:this.datePickerChange}})])}}},XXtD:function(t,e,a){"use strict";e.a={name:"sale-chart-mask",props:{loading:{type:Boolean,default:!1}},render:function(t){return t("div",{style:"position: absolute;top:28px;left:0;right:0;bottom:0"},[t("div",{style:"height:100%;position: relative;"},[t("div",{style:"position: absolute;top: 50%;left: 50%;transform: translate(-50%,-50%);font-size: 16px;"},[this.loading?"":"暂无数据"])])])}}},i9cY:function(t,e,a){"use strict";a.d(e,"a",function(){return i});a("rE2o"),a("ioFf"),a("91GP");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}function i(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:"",e=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{},a=t+"";if("object"===n(t)||!t)return 0;var i,s=Object.assign({position:"absolute",top:0,left:0,"z-index":-1e4,visibility:"hidden"},e),r=document.getElementsByTagName("body")[0],o=document.createElement("div");for(var h in s)s.hasOwnProperty(h)&&(o.style[h]=s[h]);return o.innerHTML=a,r.appendChild(o),i=o.clientWidth,r.removeChild(o),i}},khHw:function(t,e,a){"use strict";a("91GP"),a("f3/d"),a("dRSK"),a("xfY5");var n=a("nKjl"),i=a("SeVM"),s=a("XXtD");a("wDdD"),a("sRwP"),a("0o9m"),a("C0tN"),a("AH3D"),a("Ynxi"),a("zixQ");e.a={name:"chart-sale-customer-quota-distribution",components:{chart:n.a,DatePicker:i.a,ChartMask:s.a},props:{height:{type:String,default:"300px"},width:{type:String,default:"100%"},valueKey:{type:String,default:"volume"},node:{type:Number,default:5},apiObj:{type:Object,default:function(){return{}}}},data:function(){return{loading:!0,chartData:null,selectMonths:[]}},computed:{setLegendData:function(){return this.chartData&&this.chartData.legendData||[]},setSeriesData:function(){return this.chartData&&this.chartData.seriesData||[]},hasData:function(){return!!this.setSeriesData.length},defaultOption:function(){var t=this;return{title:{text:"客户销售额分布",left:"center"},tooltip:{trigger:"item",formatter:"{a}: {b}<br/>销售额: {c} ({d}%)"},legend:{type:"scroll",orient:"vertical",left:50,top:"middle",padding:[40,0],data:this.setLegendData,formatter:function(e){var a=t.setSeriesData.find(function(t){return t.name===e});return"".concat(a.name.length>16?a.name.slice(0,16)+"... ":a.name)}},series:[{name:"产品",type:"pie",radius:"55%",center:["70%","50%"],data:this.setSeriesData,label:{show:!1},labelLine:{show:!1},emphasis:{itemStyle:{shadowBlur:10,shadowOffsetX:0,shadowColor:"rgba(0, 0, 0, 0.5)"}}}]}},userInfo:function(){return this.$store.getters.userInfo},setParams:function(){return Object.assign({},this.apiObj.params,{startDate:this.selectMonths[0],endDate:this.selectMonths[1]})}},watch:{selectMonths:function(t,e){this.httpRequest()}},methods:{formatChartData:function(t){var e=this;return t.length?{legendData:t.map(function(t){return t.name}),seriesData:t.map(function(t){return{name:t.name,value:((t[e.valueKey]||0)-0).toFixed(2)}})}:{}},dateChange:function(t){this.selectMonths=t},httpRequest:function(){var t=this;this.loading=!0,this.apiObj.apiName?this.$api[this.apiObj.apiName](this.setParams).then(function(e){t.chartData=t.formatChartData(e.result||[]),t.loading=!1}).catch(function(e){t.loading=!1}):setTimeout(function(e){t.chartData=t.genData(30),t.loading=!1},3e3)},genData:function(t){for(var e=["赵","钱","孙","李","周","吴","郑","王","冯","陈","褚","卫","蒋","沈","韩","杨","朱","秦","尤","许","何","吕","施","张","孔","曹","严","华","金","魏","陶","姜","戚","谢","邹","喻","柏","水","窦","章","云","苏","潘","葛","奚","范","彭","郎","鲁","韦","昌","马","苗","凤","花","方","俞","任","袁","柳","酆","鲍","史","唐","费","廉","岑","薛","雷","贺","倪","汤","滕","殷","罗","毕","郝","邬","安","常","乐","于","时","傅","皮","卞","齐","康","伍","余","元","卜","顾","孟","平","黄","和","穆","萧","尹","姚","邵","湛","汪","祁","毛","禹","狄","米","贝","明","臧","计","伏","成","戴","谈","宋","茅","庞","熊","纪","舒","屈","项","祝","董","梁","杜","阮","蓝","闵","席","季","麻","强","贾","路","娄","危"],a=[],n=[],i={},s=0;s<t;s++)name=Math.random()>.65?r(4,1)+"·"+r(3,0):r(2,1),a.push(name),n.push({name:name,value:Math.round(1e5*Math.random())}),i[name]=s<6;return{legendData:a,seriesData:n,selected:i};function r(t,a){for(var n=Math.ceil(Math.random()*t+a),i=[],s=0;s<n;s++)i.push(e[Math.round(Math.random()*e.length-1)]);return i.join("")}}},render:function(t){return t("div",{directives:[{name:"loading",value:this.loading}],class:"resetChartViewStyle",attrs:{"element-loading-text":"数据加载中...","element-loading-spinner":"none"},style:{height:this.height}},[t("date-picker",{on:{datechange:this.dateChange},attrs:{disabledDate:!0}}),this.hasData?t("div",[t("chart",{style:{height:"".concat(parseInt(this.height)-39,"px"),width:this.width},attrs:{options:this.defaultOption}})]):t("chart-Mask",{attrs:{loading:this.loading}})])}}},"m2/r":function(t,e,a){"use strict";a("XfO3"),a("HEwt"),a("a1Th"),a("rE2o"),a("ioFf"),a("rGqo"),a("91GP"),a("f3/d"),a("KKXr"),a("xfY5");var n=a("nKjl"),i=a("SeVM"),s=a("XXtD");a("75ce"),a("0o9m"),a("C0tN"),a("AH3D"),a("Ynxi"),a("zixQ");function r(t){return function(t){if(Array.isArray(t)){for(var e=0,a=new Array(t.length);e<t.length;e++)a[e]=t[e];return a}}(t)||function(t){if(Symbol.iterator in Object(t)||"[object Arguments]"===Object.prototype.toString.call(t))return Array.from(t)}(t)||function(){throw new TypeError("Invalid attempt to spread non-iterable instance")}()}e.a={name:"chart-sale-staff-trend",components:{chart:n.a,DatePicker:i.a,ChartMask:s.a},props:{height:{type:String,default:"300px"},width:{type:String,default:"100%"},node:{type:Number,default:5},apiObj:{type:Object,default:function(){return{}}}},data:function(){return{loading:!0,chartData:null,salesVolume:[],salesNumber:[],months:[],selectMonths:[],testTimer:null}},computed:{hasData:function(){return this.chartData&&this.chartData.length},setMonths:function(){var t=this.selectMonths[0],e=this.selectMonths[1];if(!t||!e)return[];for(var a=t.split("-"),n=e.split("-"),i=12*(n[0]-0)+(n[1]-0)-(12*(a[0]-0)+(a[1]-0)),s=[],r=0;r<=i;r++)r?s[r-1][1]>11?s.push([s[r-1][0]+1,1]):s.push([s[r-1][0],s[r-1][1]+1]):s.push([a[0]-0,a[1]-0]);return s.map(function(t){return t[1]+="月",t.join("年")})},setYAxisMin:function(){return this.chartData&&this.chartData.length?Math.min.apply(Math,r(Array.prototype.concat.apply([],this.chartData.map(function(t){return t.seriesData})))):0},setYAxisMax:function(){if(!this.chartData||!this.chartData.length)return 0;var t=(Math.floor(Math.max.apply(Math,r(Array.prototype.concat.apply([],this.chartData.map(function(t){return t.seriesData})))))+"").split("");return t[0]=t[0]-0+1,t.map(function(t,e){return e?"0":t+""}).join("")-0},chartSeries:function(){return this.chartData&&this.chartData.length?this.chartData.map(function(t){return{name:t.name||"",type:"line",itemStyle:{normal:{barBorderRadius:0,label:{show:!0,position:"top",formatter:function(t){return t.value||0}}}},data:t.seriesData}}):[]},legendData:function(){return this.chartData&&this.chartData.length?this.chartData.map(function(t){return t.name}):[]},defaultOption:function(){return{title:{text:"员工销售趋势",left:"center"},tooltip:{trigger:"item"},legend:{type:"scroll",data:this.legendData,bottom:10,left:5},xAxis:[{type:"category",data:this.setMonths,axisPointer:{type:"shadow"},axisTick:{show:!1}}],yAxis:[{type:"value",name:"销售额",min:this.setYAxisMin>0?0:this.setYAxisMin,max:this.setYAxisMax,interval:this.setYAxisMax/this.node,axisTick:{show:!1},splitLine:{show:!1},axisLabel:{formatter:"{value}"}}],series:this.chartSeries}},userInfo:function(){return this.$store.getters.userInfo},setParams:function(){return Object.assign({},this.apiObj.params,{startDate:this.selectMonths[0],endDate:this.selectMonths[1]})}},watch:{selectMonths:function(t,e){this.httpRequest()}},methods:{formatChartData:function(){var t=this.chartData;t.length&&(this.salesVolume=t.map(function(t){return t.salesVolume-0}),this.salesNumber=t.map(function(t){return t.salesNumber-0}),this.months=t.map(function(t){return t.month}))},dateChange:function(t){this.selectMonths=t},httpRequest:function(){var t=this;this.loading=!0,this.apiObj.apiName?this.$api[this.apiObj.apiName](this.setParams).then(function(e){t.chartData=e.result,t.loading=!1}).catch(function(e){t.loading=!1}):(clearTimeout(this.testTimer),this.testTimer=setTimeout(function(e){t.chartData=t.createData(),t.loading=!1},3e3))},createData:function(){var t=0,e=Math.ceil(12*Math.random()),a=[];if(this.selectMonths[0]&&this.selectMonths[1]){var n,i;n=this.selectMonths[0].split("-")[0]-0,i=this.selectMonths[0].split("-")[1]-0,t=12*(this.selectMonths[1].split("-")[0]-0)+(this.selectMonths[1].split("-")[1]-0)-(12*n+i);for(var s=0;s<e;s++)a.push(this.genData(t))}return a},genData:function(t){for(var e=["赵","钱","孙","李","周","吴","郑","王","冯","陈","褚","卫","蒋","沈","韩","杨","朱","秦","尤","许","何","吕","施","张","孔","曹","严","华","金","魏","陶","姜","戚","谢","邹","喻","柏","水","窦","章","云","苏","潘","葛","奚","范","彭","郎","鲁","韦","昌","马","苗","凤","花","方","俞","任","袁","柳","酆","鲍","史","唐","费","廉","岑","薛","雷","贺","倪","汤","滕","殷","罗","毕","郝","邬","安","常","乐","于","时","傅","皮","卞","齐","康","伍","余","元","卜","顾","孟","平","黄","和","穆","萧","尹","姚","邵","湛","汪","祁","毛","禹","狄","米","贝","明","臧","计","伏","成","戴","谈","宋","茅","庞","熊","纪","舒","屈","项","祝","董","梁","杜","阮","蓝","闵","席","季","麻","强","贾","路","娄","危"],a=[],n=Math.random()>.65?s(4,1)+"·"+s(3,0):s(2,1),i=0;i<t;i++)a.push(Math.round(1e5*Math.random()));return{name:n,seriesData:a};function s(t,a){for(var n=Math.ceil(Math.random()*t+a),i=[],s=0;s<n;s++)i.push(e[Math.round(Math.random()*e.length-1)]);return i.join("")}}},render:function(t){return t("div",{directives:[{name:"loading",value:this.loading}],class:"resetChartViewStyle",attrs:{"element-loading-text":"数据加载中...","element-loading-spinner":"none"},style:{height:this.height}},[t("date-picker",{on:{datechange:this.dateChange},attrs:{disabledDate:!0}}),this.hasData?t("div",[t("chart",{style:{height:"".concat(parseInt(this.height)-39,"px"),width:this.width},attrs:{options:this.defaultOption}})]):t("chart-Mask",{attrs:{loading:this.loading}})])}}},nvec:function(t,e,a){"use strict";a("XfO3"),a("HEwt"),a("a1Th"),a("rE2o"),a("ioFf"),a("rGqo"),a("91GP"),a("KKXr"),a("xfY5");var n=a("nKjl"),i=a("SeVM"),s=a("XXtD"),r=(a("75ce"),a("lLGD"),a("sRwP"),a("0o9m"),a("Cm0C"),a("AH3D"),a("Ynxi"),a("zixQ"),a("4Cjf"));function o(t){return function(t){if(Array.isArray(t)){for(var e=0,a=new Array(t.length);e<t.length;e++)a[e]=t[e];return a}}(t)||function(t){if(Symbol.iterator in Object(t)||"[object Arguments]"===Object.prototype.toString.call(t))return Array.from(t)}(t)||function(){throw new TypeError("Invalid attempt to spread non-iterable instance")}()}e.a={name:"chart-sale-trend",components:{chart:n.a,DatePicker:i.a,ChartMask:s.a},props:{height:{type:String,default:"300px"},width:{type:String,default:"100%"},node:{type:Number,default:5},apiObj:{type:Object,default:function(){return{}}},sequence:{type:Boolean,default:!0}},data:function(){return{loading:!0,chartData:null,salesVolume:[],salesNumber:[],months:[],selectMonths:[],resultData:null}},computed:{hasData:function(){return this.chartData},setMonths:function(){return this.months.map(function(t){var e=t.split("-");return e[1]=e[1]-0+"月",e.join("年")})},setSalesNumberMin:function(){return this.salesNumber.length?Math.min.apply(Math,o(this.salesNumber))-0:0},setSalesNumberMax:function(){if(!this.salesNumber.length)return 5;var t=Math.max.apply(Math,o(this.salesNumber))-0,e=(Math.floor(t+(this.setSalesNumberMin>0?0:this.setSalesNumberMin))+"").split("");return e[0]=e[0]-0+1,e.map(function(t,e){return e?"0":t+""}).join("")-0},setSalesVolumeMin:function(){return this.salesVolume.length?Math.min.apply(Math,o(this.salesVolume))-0:0},setSalesVolumeMax:function(){if(!this.salesVolume.length)return 5;var t=Math.max.apply(Math,o(this.salesVolume))-0,e=(Math.floor(t+(this.setSalesVolumeMin>0?0:this.setSalesVolumeMin))+"").split("");return e[0]=e[0]-0+1,e.map(function(t,e){return e?"0":t+""}).join("")-0},setYAxisMin:function(){return Math.min(this.setSalesNumberMin,this.setSalesVolumeMin)},setYAxisMax:function(){return Math.max(this.setSalesNumberMax,this.setSalesVolumeMax)},defaultOption:function(){return{title:{text:"销售趋势图",left:"center"},tooltip:{trigger:"axis",axisPointer:{type:"cross",crossStyle:{color:"#999"}}},toolbox:{feature:{dataView:{show:!0,readOnly:!1},magicType:{show:!0,type:["line","bar"]},restore:{show:!0},saveAsImage:{show:!0}}},dataZoom:[{show:!0,realtime:!0,start:0,end:100},{type:"inside",realtime:!0,start:0,end:100}],legend:{data:["销售量","销售额"],left:5},xAxis:[{type:"category",data:this.setMonths,axisPointer:{type:"shadow"},axisTick:{show:!1}}],yAxis:[{type:"value",name:"销售量",min:this.setYAxisMin>0?0:this.setYAxisMin,max:this.setYAxisMax,interval:this.setYAxisMax/this.node,axisTick:{show:!1},splitLine:{show:!1},axisLabel:{formatter:"{value}"},nameTextStyle:{color:"transparent"}},{show:!1,type:"value",name:"销售额",min:this.setYAxisMin>0?0:this.setYAxisMin,max:this.setYAxisMax,interval:this.setYAxisMax/this.node,axisLabel:{formatter:"{value}"}}],series:[{name:"销售量",type:"bar",data:this.salesVolume},{name:"销售额",type:"line",yAxisIndex:1,itemStyle:{normal:{barBorderRadius:0,label:{show:!0,position:"top",formatter:function(t){return t.value||0}}}},data:this.salesNumber}]}},userInfo:function(){return this.$store.getters.userInfo},setParams:function(){return Object.assign({},this.apiObj.params,{startDate:this.selectMonths[0],endDate:this.selectMonths[1]})}},watch:{selectMonths:function(t,e){t&&t.length&&(this.useStorage(t,e)?this.resetResult(t):this.httpRequest())}},methods:{useStorage:function(t,e){return!!(t&&t.length&&e&&e.length)&&(t[0]>=e[0]&&e[1]>=t[1])},resetResult:function(t){var e=JSON.parse(this.resultData);this.chartData=e.filter(function(e){if(e.month>=t[0]&&t[1]>=e.month)return!0}),this.formatChartData()},formatChartData:function(){var t=this.chartData;t.length&&(this.salesVolume=t.map(function(t){return t.salesVolume-0}),this.salesNumber=t.map(function(t){return t.salesNumber-0}),this.months=t.map(function(t){return t.month}))},dateChange:function(t){this.selectMonths=t},httpRequest:function(){var t=this;this.loading=!0,this.apiObj.apiName?this.requestBody(this):setTimeout(function(e){t.resultData=JSON.stringify(r.a.trend.result||[]),t.chartData=r.a.trend.result||[],t.formatChartData(),t.loading=!1},3e3)},requestBody:function(t){t.$api[t.apiObj.apiName](t.setParams).then(function(e){t.resultData=JSON.stringify(e.result||[]),t.chartData=e.result||[],t.formatChartData(),t.loading=!1}).catch(function(e){t.loading=!1})}},render:function(t){return t("div",{directives:[{name:"loading",value:this.loading}],class:"resetChartViewStyle",attrs:{"element-loading-text":"数据加载中...","element-loading-spinner":"none"},style:{height:this.height}},[t("date-picker",{on:{datechange:this.dateChange},attrs:{disabledDate:!0}}),this.hasData?t("div",[t("chart",{style:{height:"".concat(parseInt(this.height)-39,"px"),width:this.width},attrs:{options:this.defaultOption}})]):t("chart-Mask",{attrs:{loading:this.loading}})])}}},zBZs:function(t,e,a){"use strict";a("XfO3"),a("HEwt"),a("a1Th"),a("rE2o"),a("ioFf"),a("rGqo"),a("f3/d");var n=a("nKjl"),i=(a("75ce"),a("lLGD"),a("Fa/5"),a("0o9m"),a("Cm0C"),a("AH3D"),a("Ynxi"),a("i9cY")),s={props:{autoResize:{type:Boolean,default:!1},environment:{type:String,default:"chart"}},data:function(){return{fontSizeScale:1}},computed:{systemInfo:function(){return this.$store.getters.systemInfo}},created:function(){this.createRootScale()},watch:{systemInfo:function(){this.createRootScale()}},methods:{createRootScale:function(){this.autoResize?"chart"===this.environment?this.fontSizeScale=this.setScale(this.systemInfo.width,this.systemInfo.height):this.fontSizeScale=this.setScale(this.systemInfo.clinetWidth,this.systemInfo.clientHeight):this.fontSizeScale=this.setScale(this.systemInfo.width,this.systemInfo.height)},setScale:function(){var t=(arguments.length>0&&void 0!==arguments[0]?arguments[0]:0)-0,e=(arguments.length>1&&void 0!==arguments[1]?arguments[1]:0)-0;return t||e?t/e<1?1:t<1024?1:(t/1024*(t/e)).toFixed(2):1}}},r=a("4Cjf");function o(t){return function(t){if(Array.isArray(t)){for(var e=0,a=new Array(t.length);e<t.length;e++)a[e]=t[e];return a}}(t)||function(t){if(Symbol.iterator in Object(t)||"[object Arguments]"===Object.prototype.toString.call(t))return Array.from(t)}(t)||function(){throw new TypeError("Invalid attempt to spread non-iterable instance")}()}e.a={name:"chart-sale-receivables",mixins:[s],components:{chart:n.a},props:{height:{type:String,default:"300px"},width:{type:String,default:"100%"},apiObj:{type:Object,default:function(){return{}}}},data:function(){return{loading:!0,chartData:null,currentIndex:1}},computed:{setFontSizeScale:function(){return this.fontSizeScale-0},hasData:function(){return this.chartData},chartDataLength:function(){return this.chartData&&this.chartData.length?this.chartData.length:0},setNameLists:function(){return this.arrayChunk(this.chartData.map(function(t){return t.name}),10)},getLongestName:function(){var t=this;if(this.setNameLists[this.currentIndex-1]){var e=this.setNameLists[this.currentIndex-1].map(function(e){return Object(i.a)(e,{color:"#000000",fontSize:"".concat(6*t.setFontSizeScale,"px")})});return Math.max.apply(Math,o(e))}return 0},setProportionLists:function(){return this.chartData?this.arrayChunk(this.chartData.map(function(t){return[0,t.proportion,t.endPlus,t.endPlusTotal,t.name]}),10):[]},setEndPlusTotal:function(){return this.chartData&&this.chartData[0].endPlusTotal||0},defaultOption:function(){var t=this;return{title:{text:"应收账款分布",left:"center",top:2*this.setFontSizeScale},tooltip:{trigger:"axis",axisPointer:{type:"none"},formatter:function(e){return"".concat(e[0].name,"<br/>应收款金额：").concat(t.setProportionLists[t.currentIndex-1][e[0].dataIndex][2],"元")}},grid:{left:"left",top:15*this.setFontSizeScale,right:10,bottom:0,containLabel:!0},xAxis:[{show:!1}],yAxis:[{axisTick:"none",axisLine:"none",offset:.75*this.getLongestName,axisLabel:{formatter:function(t){return"{value|".concat(t,"}")},align:"left",rich:{value:{color:"#000000",fontSize:7*this.setFontSizeScale}},margin:18*this.setFontSizeScale+.35*this.getLongestName},inverse:!0,data:this.setNameLists[this.currentIndex-1]},{axisTick:"none",axisLine:"none",inverse:!0,axisLabel:{textStyle:{color:"#000000",fontSize:7*this.setFontSizeScale}},data:[]},{inverse:!0,axisLine:{lineStyle:{color:"rgba(0,0,0,0)"}},data:[]}],series:[{name:"应收款占比",type:"bar",yAxisIndex:0,data:(this.setProportionLists[this.currentIndex-1]||[]).map(function(t){return t[1]}),label:{show:!0,position:"right",color:"#000000",fontSize:5*this.setFontSizeScale,offset:[10,0],formatter:function(e){return"".concat(t.setProportionLists[t.currentIndex-1][e.dataIndex][1],"%")}},barWidth:12,itemStyle:{normal:{color:"#46a6ff"}},z:3},{name:"白框",type:"bar",yAxisIndex:1,barGap:"-100%",data:this.createArr((this.setProportionLists[this.currentIndex-1]||[]).length,100),barWidth:14,itemStyle:{normal:{color:"#ffffff",barBorderRadius:5}},z:2},{name:"外框",type:"bar",yAxisIndex:2,barGap:"-100%",data:this.createArr((this.setProportionLists[this.currentIndex-1]||[]).length,100.5),barWidth:16,itemStyle:{normal:{color:"#000000",barBorderRadius:5}},z:1},{name:"外圆",type:"scatter",hoverAnimation:!1,data:this.createArr((this.setProportionLists[this.currentIndex-1]||[]).length,0),yAxisIndex:2,symbolSize:24,itemStyle:{normal:{color:"#46a6ff",opacity:1}},z:3}]}},userInfo:function(){return this.$store.getters.userInfo}},methods:{createYData:function(){var t=(arguments.length>0&&void 0!==arguments[0]?arguments[0]:[]).map(function(t){return[0,t.proportion,t.endPlus]});return console.log(t),t},httpRequest:function(){var t=this;this.loading=!0,this.apiObj.apiName?this.$api[this.apiObj.apiName](this.apiObj.params).then(function(e){t.chartData=e.result||[],t.loading=!1}).catch(function(e){t.loading=!1}):setTimeout(function(e){t.chartData=r.a.receivables.result||[],t.loading=!1},3e3)},formatChartData:function(){},currentChange:function(t){this.currentIndex=t},arrayChunk:function(t,e){for(var a=new Array,n=0,i=t.length/e,s=0;s<i;s++){for(var r=new Array,o=0;o<e&&(r[o]=t[n++],n!=t.length);o++);a[s]=r}return a},createArr:function(t,e){for(var a=[],n=0;n<t;n++)a.push(e);return a}},created:function(){this.httpRequest()},render:function(t){return t("div",{directives:[{name:"loading",value:this.loading}],class:"resetChartViewStyle",attrs:{"element-loading-text":"数据加载中...","element-loading-spinner":"none"},style:{height:this.height}},[this.hasData?t("div",[t("chart",{style:{height:"".concat(parseInt(this.height)-(this.chartDataLength>10?27:0),"px"),width:this.width},attrs:{options:this.defaultOption}}),this.chartDataLength>10?t("el-pagination",{style:{"text-align":"center"},attrs:{small:!0,layout:"prev, pager, next",total:this.chartDataLength},on:{"current-change":this.currentChange}}):null]):t("div",{style:"position: relative;height:100%;"},[t("div",{style:"position: absolute;top: 50%;left: 50%;transform: translate(-50%,-50%);"},[this.loading?"":"暂无数据"])])])}}},zixQ:function(t,e,a){}}]);