package iit.fyp.textSummarizer.preProcesses;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class StopWordEliminator {
	
	private String stopWordFilePath;
	private Set stopWordSet;
	private URL stopWordURL;
	private String stopWords;
	
    public StopWordEliminator(String stopWordFilePath) {
        this.stopWordFilePath=stopWordFilePath;
        prepareStopWordSet();

        System.out.println("");
    }

    /**
     * 
     * The Method used for the making of the stop words set
     */
    private void prepareStopWordSet(){

        HashSet hashSet=new HashSet();
        for (int i = 0; i < getStopWords().size(); i++) {

            hashSet.add(getStopWords().get(i));

        }

        this.stopWordSet=hashSet;
 
    }
    
    
    /**
     * 
     * The Method of Used For The Reading the stop words from the text file of stop
     * words given
     */
    private ArrayList getStopWords(){
        stopWords = stopwordslList();


        ArrayList arrayList=new ArrayList();


        String[] str=null;


        str = stopWords.split(",");

        for (int i = 0; i < str.length; i++) {

            String string = str[i];
            arrayList.add(string);

        }

        return arrayList;
        
        
    }
    
    /**
     * The Method Used For the Comparison of the Words As to Whether Stop
     * Words or Not
     */

    public String filterSentence(String filterSentence){

        String sentence=filterSentence;
        StringTokenizer stringTokenizer = new StringTokenizer(sentence, " ",false);

        String senten="";
        String token;
        String checktoken=null;
        int i=0;
        while (stringTokenizer.hasMoreTokens()) {
                   
            token=stringTokenizer.nextToken();
            checktoken=token.toLowerCase();

            int strlength = checktoken.length()-1;
            if(checktoken.substring(strlength).equals(".") ||
                    checktoken.substring(strlength).equals(",") ||
                    checktoken.substring(strlength).equals(";") ||
                    checktoken.substring(strlength).equals(":") ||
                    checktoken.substring(strlength).equals("?")){
                checktoken = checktoken.substring(0,(strlength));

            }

            if(!stopWordSet.contains(checktoken))
            {
                if(i==0)
                    senten=token;
                else
                    senten=senten + " " + token;
            }

            i++;
        }
        
        return senten;

    }


    private String stopwordslList(){

        String ret = "a,ii,about,above,according,across,39,actually,ad,adj,ae,af," +
                "after,after,wards,ag,again,against,ai,al,all,almost,alone,along," +
                "already,also,although,always,am,among,amongst,an,and,another,any," +
                "anyhow,anyone,anything,anywhere,ao,aq,ar,are,aren,aren't,around," +
                "arpa,as,at,au,aw,az,b,ba,bb,bd,be,became,because,become,becomes," +
                "becoming,been,before,beforehand,begin,beginning,behind,being," +
                "below,beside,besides,between,beyond,bf,bg,bh,bi,billion,bj,bm," +
                "bn,bo,both,br,bs,bt,but,buy,bv,bw,by,bz,c,ca,can,can't,cannot," +
                "caption,cc,cd,cf,cg,ch,ci,ck,cl,click,cm,cn,co,co.,com,copy," +
                "could,couldn,couldn't,cr,cs,cu,cv,cx,cy,cz,d,de,did,didn,didn't," +
                "dj,dk,dm,do,does,doesn,doesn't,don,don't,down,during,dz,e,each," +
                "ec,edu,ee,eg,eh,eight,eighty,either,else,elsewhere,end,ending," +
                "enough,er,es,et,etc,even,ever,every,everyone,everything," +
                "everywhere,except,f,few,fi,fifty,find,first,five,fj,fk,fm,fo," +
                "forformer,formerly,forty,found,four,fr,free,from,further,fx,g,ga," +
                "gb,gd,ge,get,gf,gg,gh,gi,gl,gm,gmt,gn,go,gov,gp,gq,gr,gs,gt,gu,gw," +
                "gy,h,had,has,hasn,hasn't,have,haven,haven't,he,he'd,he'll,he's,help" +
                ",hence,her,here,here's,hereafter,hereby,herein,hereupon,hers,herself," +
                "him,himself,his,hk,hm,hn,home,homepage,how,however,hr,ht,htm,html,http," +
                "hu,hundred,i,i'd,i'll,i'm,i've,i.e.,id,ie,if,il,im,in,inc,inc.,indeed," +
                "information,instead,int,into,io,iq,ir,is,isn,isn't,it,it's,its,itself," +
                "j,je,jm,jo,join,jp,k,ke,kg,kh,ki,km,kn,kp,kr,kw,ky,kz,l,la," +
                "last,later,latter,lb,lc,least,less,let,let's,li,like,likely,lk," +
                "ll,lr,ls,lt,ltd,lu,lv,ly,m,ma,made,make,makes,many,maybe,mc,md," +
                "me,meantime,meanwhile,mg,mh,microsoft,might,mil,million,miss,mk," +
                "ml,mm,mn,mo,more,moreover,most,mostly,mp,mq,mr,mrs,ms,msie,mt," +
                "mu,much,must,mv,mw,mx,my,myself,mz,n,na,namely,nc,ne,neither," +
                "net,netscape,never,nevertheless,new,next,nf,ng,ni,nine,ninety," +
                "nl,no,nobody,none,nonetheless,noone,nor,not,nothing,now," +
                "nowhere,np,nr,nu,nz,o,of,off,often,om,on,once,one,one's,only," +
                "onto,or,org,other,others,otherwise,our,ours,ourselves,out,over," +
                "overall,own,p,pa,page,pe,per,perhaps,pf,pg,ph,pk,pl,pm,pn,pr,pt," +
                "pw,py,q,qa,r,rather,re,recent,recently,reserved,ring,ro,ru,rw,s," +
                "sa,same,sb,sc,sd,se,seem,seemed,seeming,seems,seven,seventy,several," +
                "sg,sh,she,she'd,she'll,she's,should,shouldn,shouldn't,si,since,site," +
                "six,sixty,sj,sk,sl,sm,sn,so,some,somehow,someone,something,sometime," +
                "sometimes,somewhere,sr,st,still,stop,su,such,sv,sy,sz,t,taking,tc,td,ten," +
                "text,tf,tg,test,the,than,that,that'll,that's,the,their,them,themselves,then," +
                "thence,there,there'll,there's,thereafter,thereby,therefore,therein,thereupon," +
                "these,they,they'd,they'll,they're,they've,thirty,this,those,though,thousand," +
                "three,through,throughout,thru,thus,tj,tk,tm,tn,to,together,too,toward,towards" +
                ",tp,tr,trillion,tt,tv,tw,twenty,two,tz,ua,ug,uk,um,under,unless,unlike,unlikely" +
                ",until,up,upon,us,use,used,using,uy,uz,v,va,vc,ve,very,vg,vi,via,vn,vu,w,was,wasn," +
                "wasn't,we,we'd,we'll,we're,we've,web,webpage,website,welcome,well,were,weren,weren't" +
                ",wf,what,what'll,what's,whatever,when,whence,whenever,where,whereafter,whereas,whereby," +
                "wherein,whereupon,wherever,whether,which,while,whither,who," +
                "who'd,who'll,who's,whoever,NULL,whole,whom,whomever,whose,why," +
                "will,with,within,without,won,won't,would,wouldn,wouldn't,ws," +
                "www,x,y,ye,yes,yet,you,you'd,you'll,you're,you've,your,yours," +
                "yourself,yourselves,yt,yu,z,za,zm,zr,10,z,org,inc,width,length,for";

        return ret;

    }
    
public static void main(String args[]){
		
		StopWordEliminator SWE = new StopWordEliminator("stopWord.txt");
		System.out.println(SWE.getStopWords().size());
		
	}




}
