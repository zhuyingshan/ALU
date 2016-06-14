import java.util.Arrays;

/**
 * 模拟ALU进行整数和浮点数的四则运算
 * @author 151250214_朱应山
 *
 */

public class ALU {
	/**
	 * 生成十进制整数的二进制补码表示。<br/>
	 * 例：integerRepresentation("9", 8)
	 * @param number 十进制整数。若为负数；则第一位为“-”；若为正数或 0，则无符号位
	 * @param length 二进制补码表示的长度
	 * @return number的二进制补码表示，长度为length
	 */
	public String integerRepresentation (String number, int length) {
		String bString="";
		int sign;
		if (number.charAt(0)=='-') {//负数
			number=number.substring(1);
			sign=1;
			bString=toBinaryStr(number);
			
		}else {
			sign=0;
			bString=toBinaryStr(number);
		}
		
		if (bString.length()<length-1) {
			for (int i = bString.length(); i < length-1; i++) {
			bString="0"+bString;
			}
		}
		if (sign==1) {
			bString=negation(bString);//待完善，还需要加一
		}
		return sign+bString;
	}
	
	/**将输入的十进制string改写成二进制的string*/
	public String toBinaryStr(String tenStr) {
		int binaryNum=0;
		int a=1;
		int tenNum=Integer.parseInt(tenStr);
		for (int i = 0; tenNum >0; i++) {
			int nowNum =tenNum%2;
			tenNum=tenNum/2;
			binaryNum=nowNum*a+binaryNum;
			a=a*10;
		}
		return binaryNum+"";
	}
	public char ORGate(char c1,char c2) {
		char c='0';
		if (c1=='1'||c2=='1') {
			c='1';
		}
		return c;
	}
	public char ANDGate(char c1,char c2) {
		char c='0';
		if (c1==c2&&c1=='1') {
			c='1';
		}
		return c;
	}
	
	public char NOTGate(char c1) {
		char c='0';
		if (c1=='0') {
			c='1';
		}
		return c;
	}
	
	public char  XORGate(char c1,char c2) {
		char c='0';
		if (c1!=c2) {
			c='1';
		}
		return c;
	}
	/**
	 * 生成十进制浮点数的二进制表示。
	 * 需要考虑 0、反规格化、正负无穷（“+Inf”和“-Inf”）、 NaN等因素，具体借鉴 IEEE 754。
	 * 舍入策略为向0舍入。<br/>
	 * 例：floatRepresentation("11.375", 8, 11)
	 * @param number 十进制浮点数，包含小数点。若为负数；则第一位为“-”；若为正数或 0，则无符号位
	 * @param eLength 指数的长度，取值大于等于 4
	 * @param sLength 尾数的长度，取值大于等于 4
	 * @return number的二进制表示，长度为 1+eLength+sLength。从左向右，依次为符号、指数（移码表示）、尾数（首位隐藏）
	 */
	public String floatRepresentation (String number, int eLength, int sLength) {
		
		return null;
	}
	
	/**
	 * 生成十进制浮点数的IEEE 754表示，要求调用{@link #floatRepresentation(String, int, int) floatRepresentation}实现。<br/>
	 * 例：ieee754("11.375", 32)
	 * @param number 十进制浮点数，包含小数点。若为负数；则第一位为“-”；若为正数或 0，则无符号位
	 * @param length 二进制表示的长度，为32或64
	 * @return number的IEEE 754表示，长度为length。从左向右，依次为符号、指数（移码表示）、尾数（首位隐藏）
	 */
	public String ieee754 (String number, int length) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * 计算二进制补码表示的整数的真值。<br/>
	 * 例：integerTrueValue("00001001")
	 * @param operand 二进制补码表示的操作数
	 * @return operand的真值。若为负数；则第一位为“-”；若为正数或 0，则无符号位
	 */
	public static String integerTrueValue (String operand) {
		int sort=0;
		int a=1;
		if (operand.charAt(0)=='1') {
		    for (int i = 0; i < operand.length()-1; i++) {
				sort=sort+(operand.charAt(operand.length()-i-1)-48)*a;
				a=a*2;
			}
			sort=sort+(operand.charAt(0)-48)*(-a);
		}else{
			for (int i = 0; i < operand.length()-1; i++) {
				char q=operand.charAt(operand.length()-i-1);
				sort=sort+(operand.charAt(operand.length()-i-1)-48)*a;
				a=a*2;
			}
		}
		return sort+"" ;
	}
	
	/**
	 * 计算二进制原码表示的浮点数的真值。<br/>
	 * 例：floatTrueValue("01000001001101100000", 8, 11)
	 * @param operand 二进制表示的操作数
	 * @param eLength 指数的长度，取值大于等于 4
	 * @param sLength 尾数的长度，取值大于等于 4
	 * @return operand的真值。若为负数；则第一位为“-”；若为正数或 0，则无符号位。正负无穷分别表示为“+Inf”和“-Inf”， NaN表示为“NaN”
	 */
	public String floatTrueValue (String operand, int eLength, int sLength) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * 按位取反操作。<br/>
	 * 例：negation("00001001")
	 * @param operand 二进制表示的操作数
	 * @return operand按位取反的结果
	 */
	public String negation (String operand) {
	    String newstr="";
	    char[] str=operand.toCharArray();
	    for (char c : str) {
			c=NOTGate(c);
			newstr=newstr+c;
		}
	    
		return newstr;
	}
	/**
	 * 左移操作。<br/>
	 * 例：leftShift("00001001", 2)
	 * @param operand 二进制表示的操作数
	 * @param n 左移的位数
	 * @return operand左移n位的结果
	 */
	public String leftShift (String operand, int n) {
		char[] mainStr=operand.toCharArray();
		String strForReturn="";
		for (int i = 0; i < n; i++) {
			for (int j =0; j <mainStr.length-1; j++) {
				mainStr[j]=mainStr[j+1];
				
			}
			mainStr[mainStr.length-1]='0';
		}
		for (int i = 0; i < mainStr.length; i++) {
			strForReturn=strForReturn+mainStr[i];
		}
		return strForReturn;
	}
	
	/**
	 * 逻辑右移操作。<br/>
	 * 例：logRightShift("11110110", 2)
	 * @param operand 二进制表示的操作数
	 * @param n 右移的位数
	 * @return operand逻辑右移n位的结果
	 */
	public String logRightShift (String operand, int n) {
		char[] mainStr=operand.toCharArray();
		String strForReturn="";
		for (int i = 0; i < n; i++) {
			for (int j =mainStr.length-1; j >0; j--) {
				mainStr[j]=mainStr[j-1];
				
			}
			mainStr[0]='0';
		}
		for (int i = 0; i < mainStr.length; i++) {
			strForReturn=strForReturn+mainStr[i];
		}
		return strForReturn;
	}
	
	/**
	 * 算术右移操作。<br/>
	 * 例：logRightShift("11110110", 2)
	 * @param operand 二进制表示的操作数
	 * @param n 右移的位数
	 * @return operand算术右移n位的结果
	 */
	public String ariRightShift (String operand, int n) {
		char[] mainStr=operand.toCharArray();
		String strForReturn="";
		for (int i = 0; i < n; i++) {
			for (int j =mainStr.length-1; j >0; j--) {
				mainStr[j]=mainStr[j-1];
				
			}
		}
		for (int i = 0; i < mainStr.length; i++) {
			strForReturn=strForReturn+mainStr[i];
		}
		return strForReturn;
	}
	
	/**
	 * 全加器，对两位以及进位进行加法运算。<br/>
	 * 例：fullAdder('1', '1', '0')
	 * @param x 被加数的某一位，取0或1
	 * @param y 加数的某一位，取0或1
	 * @param c 低位对当前位的进位，取0或1
	 * @return 相加的结果，用长度为2的字符串表示，第1位表示进位，第2位表示和
	 */
	public String fullAdder (char x, char y, char c) {
		char carry,sum;
		sum=XORGate(XORGate(x, y), c);
		carry=ORGate(ANDGate(y, c), ORGate(ANDGate(x, y), ANDGate(x,c)));
		return carry+""+sum;
	}
	
	/**
	 * 4位先行进位加法器。要求采用{@link #fullAdder(char, char, char) fullAdder}来实现<br/>
	 * 例：claAdder("1001", "0001", '1')
	 * @param operand1 4位二进制表示的被加数
	 * @param operand2 4位二进制表示的加数
	 * @param c 低位对当前位的进位，取0或1
	 * @return 长度为5的字符串表示的计算结果，其中第1位是最高位进位，后4位是相加结果，其中进位不可以由循环获得
	 */
	public String claAdder (String operand1, String operand2, char c) {
		char[]c1=operand1.toCharArray();
		char[]c2=operand2.toCharArray();
		char[]carryIn={'0','0','0','0',c};
		char[]P=new char[4];
		char[]G=new char[4];
		for (int i =3; i >=0; i--) {
			P[i]=ORGate(c1[i], c2[i]);
			G[i]=ANDGate(c1[i], c2[i]);
			
		}
		carryIn[3]=ORGate(G[3],ANDGate(P[3],carryIn[4]));
		carryIn[2]=ORGate(ORGate(G[2], ANDGate(P[2], G[3])), ANDGate(carryIn[4], ANDGate(P[3], P[2])));
		carryIn[1]=ORGate(ORGate(G[1], ANDGate(P[1], G[2])), ORGate(ANDGate(ANDGate(P[1], P[2]), G[3]), ANDGate(ANDGate(P[1], P[2]), ANDGate(P[3], carryIn[4]))));
		carryIn[0]=ORGate(ORGate(ORGate(G[0], ANDGate(P[0], G[1])), ORGate(ANDGate(ANDGate(P[0], P[1]), G[2]), ANDGate(ANDGate(P[0], P[1]), ANDGate(P[2], G[3])))), ANDGate(ANDGate(ANDGate(P[0], P[1]), P[2]), ANDGate(P[3], carryIn[0])));
		String output=carryIn[0]+"";
		for (int i = 0; i < 4; i++) {
			output=output+fullAdder(P[i], G[i], carryIn[i+1]).charAt(1);
		}
		return output;
	}
	
	/**
	 * 加一器，实现操作数加1的运算。
	 * 需要采用与门、或门、异或门等模拟，
	 * 不可以直接调用{@link #fullAdder(char, char, char) fullAdder}、
	 * {@link #claAdder(String, String, char) claAdder}、
	 * {@link #adder(String, String, char, int) adder}、
	 * {@link #integerAddition(String, String, int) integerAddition}方法。<br/>
	 * 例：oneAdder("00001001")
	 * @param operand 二进制补码表示的操作数
	 * @return operand加1的结果，长度为operand的长度加1，其中第1位指示是否溢出（溢出为1，否则为0），其余位为相加结果
	 */
	public String oneAdder (String operand) {
		String str="";
		char [] sum=new char [operand.length()];
		char carryIn='0',x='1';
	    for (int i =operand.length()-1; i >=0; i-- ){
	    	sum[i]=sum[i]=XORGate(XORGate(x, operand.charAt(i)), carryIn);
	    	carryIn=ORGate(ANDGate(operand.charAt(i), carryIn), ORGate(ANDGate(x, operand.charAt(i)), ANDGate(x,carryIn)));
	    	str=sum[i]+str;
	    	x='0';
		}
		str=carryIn+str;
		return str;
	}
	
	/**
	 * 加法器，要求调用{@link #claAdder(String, String, char)}方法实现。<br/>
	 * 例：adder("0100", "0011", ‘0’, 8)
	 * @param operand1 二进制补码表示的被加数
	 * @param operand2 二进制补码表示的加数
	 * @param c 最低位进位
	 * @param length 存放操作数的寄存器的长度，为4的倍数。length不小于操作数的长度，当某个操作数的长度小于length时，需要在高位补符号位
	 * @return 长度为length+1的字符串表示的计算结果，其中第1位指示是否溢出（溢出为1，否则为0），后length位是相加结果
	 */
	public String adder (String operand1, String operand2, char c, int length) {
		String output="";
		operand1=signExpand(operand1, length);
		operand2=signExpand(operand2, length);
		int times=length/4;
		char cn = '0',cn_1='0';
		for (int i =times-1; i>=0; i--) {
			String c1=operand1.substring(i*4,4*i+4);
			String c2=operand2.substring(i*4,4*i+4);
			if (i==0) {
				cn=claAdderCont(c1, c2, c).charAt(0);
				cn_1=claAdderCont(c1, c2, c).charAt(1);
				output=claAdder(c1, c2, c).substring(1)+output;
			}else{
			output=claAdder(c1, c2, c).substring(1)+output;
			}
			c=claAdder(c1, c2, c).charAt(0);
		}
		if (XORGate(cn, cn_1)=='1') {//溢出
			output="1"+output;
		}else{
			output="0"+output;
		}
		return output;
	}
	
	
	public String claAdderCont (String operand1, String operand2, char c) {
		char[]c1=operand1.toCharArray();
		char[]c2=operand2.toCharArray();
		char[]carryIn={'0','0','0','0',c};
		char[]P=new char[4];
		char[]G=new char[4];
		for (int i =3; i >=0; i--) {
			P[i]=ORGate(c1[i], c2[i]);
			G[i]=ANDGate(c1[i], c2[i]);
			
		}
		carryIn[3]=ORGate(G[3],ANDGate(P[3],carryIn[4]));
		carryIn[2]=ORGate(ORGate(G[2], ANDGate(P[2], G[3])), ANDGate(carryIn[4], ANDGate(P[3], P[2])));
		carryIn[1]=ORGate(ORGate(G[1], ANDGate(P[1], G[2])), ORGate(ANDGate(ANDGate(P[1], P[2]), G[3]), ANDGate(ANDGate(P[1], P[2]), ANDGate(P[3], carryIn[4]))));
		carryIn[0]=ORGate(ORGate(ORGate(G[0], ANDGate(P[0], G[1])), ORGate(ANDGate(ANDGate(P[0], P[1]), G[2]), ANDGate(ANDGate(P[0], P[1]), ANDGate(P[2], G[3])))), ANDGate(ANDGate(ANDGate(P[0], P[1]), P[2]), ANDGate(P[3], carryIn[0])));
		String output=carryIn[0]+"";
		for (int i = 0; i < 4; i++) {
			output=output+fullAdder(P[i], G[i], carryIn[i+1]).charAt(1);
		}
		return carryIn[0]+""+carryIn[1];
	}

	public String signExpand(String oldstr,int length) {
		if (oldstr.length()>length) {
			System.out.println("不能符号拓展");
		}
		while (oldstr.length()<length) {
			oldstr=oldstr.charAt(0)+oldstr;
			
		}
		return oldstr;
		
	}
	/**
	 * 整数加法，要求调用{@link #adder(String, String, char, int) adder}方法实现。<br/>
	 * 例：integerAddition("0100", "0011", 8)
	 * @param operand1 二进制补码表示的被加数
	 * @param operand2 二进制补码表示的加数
	 * @param length 存放操作数的寄存器的长度，为4的倍数。length不小于操作数的长度，当某个操作数的长度小于length时，需要在高位补符号位
	 * @return 长度为length+1的字符串表示的计算结果，其中第1位指示是否溢出（溢出为1，否则为0），后length位是相加结果
	 */
	public String integerAddition (String operand1, String operand2, int length) {
		String output=adder(operand1, operand2, '0', length);
		return output;
	}
	
	/**
	 * 整数减法，可调用{@link #adder(String, String, char, int) adder}方法实现。<br/>
	 * 例：integerSubtraction("0100", "0011", 8)
	 * @param operand1 二进制补码表示的被减数
	 * @param operand2 二进制补码表示的减数
	 * @param length 存放操作数的寄存器的长度，为4的倍数。length不小于操作数的长度，当某个操作数的长度小于length时，需要在高位补符号位
	 * @return 长度为length+1的字符串表示的计算结果，其中第1位指示是否溢出（溢出为1，否则为0），后length位是相减结果
	 */
	public String integerSubtraction (String operand1, String operand2, int length) {
		operand2=oneAdder(negation(operand2)).substring(1);
		return integerAddition(operand1, operand2, length);
		
	}
	
	/**
	 * 整数乘法，使用Booth算法实现，可调用{@link #adder(String, String, char, int) adder}等方法。<br/>
	 * 例：integerMultiplication("0100", "0011", 8)
	 * @param operand1 二进制补码表示的被乘数
	 * @param operand2 二进制补码表示的乘数
	 * @param length 存放操作数的寄存器的长度，为4的倍数。length不小于操作数的长度，当某个操作数的长度小于length时，需要在高位补符号位
	 * @return 长度为length+1的字符串表示的相乘结果，其中第1位指示是否溢出（溢出为1，否则为0），后length位是相乘结果
	 */
	public String integerMultiplication (String operand1, String operand2, int length) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * 整数的不恢复余数除法，可调用{@link #adder(String, String, char, int) adder}等方法实现。<br/>
	 * 例：integerDivision("0100", "0011", 8)
	 * @param operand1 二进制补码表示的被除数
	 * @param operand2 二进制补码表示的除数
	 * @param length 存放操作数的寄存器的长度，为4的倍数。length不小于操作数的长度，当某个操作数的长度小于length时，需要在高位补符号位
	 * @return 长度为2*length+1的字符串表示的相除结果，其中第1位指示是否溢出（溢出为1，否则为0），其后length位为商，最后length位为余数
	 */
	public String integerDivision (String operand1, String operand2, int length) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * 带符号整数加法，可以调用{@link #adder(String, String, char, int) adder}等方法，
	 * 但不能直接将操作数转换为补码后使用{@link #integerAddition(String, String, int) integerAddition}、
	 * {@link #integerSubtraction(String, String, int) integerSubtraction}来实现。<br/>
	 * 例：signedAddition("1100", "1011", 8)
	 * @param operand1 二进制原码表示的被加数，其中第1位为符号位
	 * @param operand2 二进制原码表示的加数，其中第1位为符号位
	 * @param length 存放操作数的寄存器的长度，为4的倍数。length不小于操作数的长度（不包含符号），当某个操作数的长度小于length时，需要将其长度扩展到length
	 * @return 长度为length+2的字符串表示的计算结果，其中第1位指示是否溢出（溢出为1，否则为0），第2位为符号位，后length位是相加结果
	 */
	public String signedAddition (String operand1, String operand2, int length) {
		char sign=operand1.charAt(0);
		String num1=operand1.substring(1);
		String num2=operand2.substring(1);
		String output="";
		if (operand1.charAt(0)!=operand2.charAt(0)) {
			output=adder(num1, num2, '0', length);
			String big,small;
			loop:for (int i = 0; i < num1.length(); i++) {
				   if (num1.charAt(i)!=num2.charAt(i)) {
				       sign=(num1.charAt(i)=='1')?operand1.charAt(0):operand2.charAt(0);
				        break loop;
				    }
			    }
		if (num1.charAt(0)==sign) {
			big=num1;
			small=num2;
		}else {
			big=num2;
			small=num1;
		}
		output=adder(big, oneAdder(negation(small)), '0', length);
		    output=output.charAt(0)+sign+output.substring(1);
		}else{
			output=adder(num1, num2, '0', length);
		    output=output.charAt(0)+""+sign+output.substring(1);
		}
		return output;
	}
	
	/**
	 * 浮点数加法，可调用{@link #signedAddition(String, String, int) signedAddition}等方法实现。<br/>
	 * 例：floatAddition("00111111010100000", "00111111001000000", 8, 8, 8)
	 * @param operand1 二进制表示的被加数
	 * @param operand2 二进制表示的加数
	 * @param eLength 指数的长度，取值大于等于 4
	 * @param sLength 尾数的长度，取值大于等于 4
	 * @param gLength 保护位的长度
	 * @return 长度为2+eLength+sLength的字符串表示的相加结果，其中第1位指示是否指数上溢（溢出为1，否则为0），其余位从左到右依次为符号、指数（移码表示）、尾数（首位隐藏）。舍入策略为向0舍入
	 */
	public String floatAddition (String operand1, String operand2, int eLength, int sLength, int gLength) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * 浮点数减法，可调用{@link #floatAddition(String, String, int, int, int) floatAddition}方法实现。<br/>
	 * 例：floatSubtraction("00111111010100000", "00111111001000000", 8, 8, 8)
	 * @param operand1 二进制表示的被减数
	 * @param operand2 二进制表示的减数
	 * @param eLength 指数的长度，取值大于等于 4
	 * @param sLength 尾数的长度，取值大于等于 4
	 * @param gLength 保护位的长度
	 * @return 长度为2+eLength+sLength的字符串表示的相减结果，其中第1位指示是否指数上溢（溢出为1，否则为0），其余位从左到右依次为符号、指数（移码表示）、尾数（首位隐藏）。舍入策略为向0舍入
	 */
	public String floatSubtraction (String operand1, String operand2, int eLength, int sLength, int gLength) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * 浮点数乘法，可调用{@link #integerMultiplication(String, String, int) integerMultiplication}等方法实现。<br/>
	 * 例：floatMultiplication("00111110111000000", "00111111000000000", 8, 8)
	 * @param operand1 二进制表示的被乘数
	 * @param operand2 二进制表示的乘数
	 * @param eLength 指数的长度，取值大于等于 4
	 * @param sLength 尾数的长度，取值大于等于 4
	 * @return 长度为2+eLength+sLength的字符串表示的相乘结果,其中第1位指示是否指数上溢（溢出为1，否则为0），其余位从左到右依次为符号、指数（移码表示）、尾数（首位隐藏）。舍入策略为向0舍入
	 */
	public String floatMultiplication (String operand1, String operand2, int eLength, int sLength) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * 浮点数除法，可调用{@link #integerDivision(String, String, int) integerDivision}等方法实现。<br/>
	 * 例：floatDivision("00111110111000000", "00111111000000000", 8, 8)
	 * @param operand1 二进制表示的被除数
	 * @param operand2 二进制表示的除数
	 * @param eLength 指数的长度，取值大于等于 4
	 * @param sLength 尾数的长度，取值大于等于 4
	 * @return 长度为2+eLength+sLength的字符串表示的相乘结果,其中第1位指示是否指数上溢（溢出为1，否则为0），其余位从左到右依次为符号、指数（移码表示）、尾数（首位隐藏）。舍入策略为向0舍入
	 */
	public String floatDivision (String operand1, String operand2, int eLength, int sLength) {
		// TODO YOUR CODE HERE.
		return null;
	}

    public  static void  main(String []args) {
		ALU alu=new ALU();
		String string="1234";
		String s=string.substring(0,4);
		System.out.println(alu.signedAddition("0011","0001",4));
	}
}
