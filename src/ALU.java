import java.util.Arrays;

/**
 * ģ��ALU���������͸���������������
 * @author 151250214_��Ӧɽ
 *
 */

public class ALU {
	/**
	 * ����ʮ���������Ķ����Ʋ����ʾ��<br/>
	 * ����integerRepresentation("9", 8)
	 * @param number ʮ������������Ϊ���������һλΪ��-������Ϊ������ 0�����޷���λ
	 * @param length �����Ʋ����ʾ�ĳ���
	 * @return number�Ķ����Ʋ����ʾ������Ϊlength
	 */
	public String integerRepresentation (String number, int length) {
		String bString="";
		int sign;
		if (number.charAt(0)=='-') {//����
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
			bString=negation(bString);//�����ƣ�����Ҫ��һ
		}
		return sign+bString;
	}
	
	/**�������ʮ����string��д�ɶ����Ƶ�string*/
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
	 * ����ʮ���Ƹ������Ķ����Ʊ�ʾ��
	 * ��Ҫ���� 0������񻯡����������+Inf���͡�-Inf������ NaN�����أ������� IEEE 754��
	 * �������Ϊ��0���롣<br/>
	 * ����floatRepresentation("11.375", 8, 11)
	 * @param number ʮ���Ƹ�����������С���㡣��Ϊ���������һλΪ��-������Ϊ������ 0�����޷���λ
	 * @param eLength ָ���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @param sLength β���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @return number�Ķ����Ʊ�ʾ������Ϊ 1+eLength+sLength���������ң�����Ϊ���š�ָ���������ʾ����β������λ���أ�
	 */
	public String floatRepresentation (String number, int eLength, int sLength) {
		
		return null;
	}
	
	/**
	 * ����ʮ���Ƹ�������IEEE 754��ʾ��Ҫ�����{@link #floatRepresentation(String, int, int) floatRepresentation}ʵ�֡�<br/>
	 * ����ieee754("11.375", 32)
	 * @param number ʮ���Ƹ�����������С���㡣��Ϊ���������һλΪ��-������Ϊ������ 0�����޷���λ
	 * @param length �����Ʊ�ʾ�ĳ��ȣ�Ϊ32��64
	 * @return number��IEEE 754��ʾ������Ϊlength���������ң�����Ϊ���š�ָ���������ʾ����β������λ���أ�
	 */
	public String ieee754 (String number, int length) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * ��������Ʋ����ʾ����������ֵ��<br/>
	 * ����integerTrueValue("00001001")
	 * @param operand �����Ʋ����ʾ�Ĳ�����
	 * @return operand����ֵ����Ϊ���������һλΪ��-������Ϊ������ 0�����޷���λ
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
	 * ���������ԭ���ʾ�ĸ���������ֵ��<br/>
	 * ����floatTrueValue("01000001001101100000", 8, 11)
	 * @param operand �����Ʊ�ʾ�Ĳ�����
	 * @param eLength ָ���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @param sLength β���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @return operand����ֵ����Ϊ���������һλΪ��-������Ϊ������ 0�����޷���λ����������ֱ��ʾΪ��+Inf���͡�-Inf���� NaN��ʾΪ��NaN��
	 */
	public String floatTrueValue (String operand, int eLength, int sLength) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * ��λȡ��������<br/>
	 * ����negation("00001001")
	 * @param operand �����Ʊ�ʾ�Ĳ�����
	 * @return operand��λȡ���Ľ��
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
	 * ���Ʋ�����<br/>
	 * ����leftShift("00001001", 2)
	 * @param operand �����Ʊ�ʾ�Ĳ�����
	 * @param n ���Ƶ�λ��
	 * @return operand����nλ�Ľ��
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
	 * �߼����Ʋ�����<br/>
	 * ����logRightShift("11110110", 2)
	 * @param operand �����Ʊ�ʾ�Ĳ�����
	 * @param n ���Ƶ�λ��
	 * @return operand�߼�����nλ�Ľ��
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
	 * �������Ʋ�����<br/>
	 * ����logRightShift("11110110", 2)
	 * @param operand �����Ʊ�ʾ�Ĳ�����
	 * @param n ���Ƶ�λ��
	 * @return operand��������nλ�Ľ��
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
	 * ȫ����������λ�Լ���λ���мӷ����㡣<br/>
	 * ����fullAdder('1', '1', '0')
	 * @param x ��������ĳһλ��ȡ0��1
	 * @param y ������ĳһλ��ȡ0��1
	 * @param c ��λ�Ե�ǰλ�Ľ�λ��ȡ0��1
	 * @return ��ӵĽ�����ó���Ϊ2���ַ�����ʾ����1λ��ʾ��λ����2λ��ʾ��
	 */
	public String fullAdder (char x, char y, char c) {
		char carry,sum;
		sum=XORGate(XORGate(x, y), c);
		carry=ORGate(ANDGate(y, c), ORGate(ANDGate(x, y), ANDGate(x,c)));
		return carry+""+sum;
	}
	
	/**
	 * 4λ���н�λ�ӷ�����Ҫ�����{@link #fullAdder(char, char, char) fullAdder}��ʵ��<br/>
	 * ����claAdder("1001", "0001", '1')
	 * @param operand1 4λ�����Ʊ�ʾ�ı�����
	 * @param operand2 4λ�����Ʊ�ʾ�ļ���
	 * @param c ��λ�Ե�ǰλ�Ľ�λ��ȡ0��1
	 * @return ����Ϊ5���ַ�����ʾ�ļ����������е�1λ�����λ��λ����4λ����ӽ�������н�λ��������ѭ�����
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
	 * ��һ����ʵ�ֲ�������1�����㡣
	 * ��Ҫ�������š����š�����ŵ�ģ�⣬
	 * ������ֱ�ӵ���{@link #fullAdder(char, char, char) fullAdder}��
	 * {@link #claAdder(String, String, char) claAdder}��
	 * {@link #adder(String, String, char, int) adder}��
	 * {@link #integerAddition(String, String, int) integerAddition}������<br/>
	 * ����oneAdder("00001001")
	 * @param operand �����Ʋ����ʾ�Ĳ�����
	 * @return operand��1�Ľ��������Ϊoperand�ĳ��ȼ�1�����е�1λָʾ�Ƿ���������Ϊ1������Ϊ0��������λΪ��ӽ��
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
	 * �ӷ�����Ҫ�����{@link #claAdder(String, String, char)}����ʵ�֡�<br/>
	 * ����adder("0100", "0011", ��0��, 8)
	 * @param operand1 �����Ʋ����ʾ�ı�����
	 * @param operand2 �����Ʋ����ʾ�ļ���
	 * @param c ���λ��λ
	 * @param length ��Ų������ļĴ����ĳ��ȣ�Ϊ4�ı�����length��С�ڲ������ĳ��ȣ���ĳ���������ĳ���С��lengthʱ����Ҫ�ڸ�λ������λ
	 * @return ����Ϊlength+1���ַ�����ʾ�ļ����������е�1λָʾ�Ƿ���������Ϊ1������Ϊ0������lengthλ����ӽ��
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
		if (XORGate(cn, cn_1)=='1') {//���
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
			System.out.println("���ܷ�����չ");
		}
		while (oldstr.length()<length) {
			oldstr=oldstr.charAt(0)+oldstr;
			
		}
		return oldstr;
		
	}
	/**
	 * �����ӷ���Ҫ�����{@link #adder(String, String, char, int) adder}����ʵ�֡�<br/>
	 * ����integerAddition("0100", "0011", 8)
	 * @param operand1 �����Ʋ����ʾ�ı�����
	 * @param operand2 �����Ʋ����ʾ�ļ���
	 * @param length ��Ų������ļĴ����ĳ��ȣ�Ϊ4�ı�����length��С�ڲ������ĳ��ȣ���ĳ���������ĳ���С��lengthʱ����Ҫ�ڸ�λ������λ
	 * @return ����Ϊlength+1���ַ�����ʾ�ļ����������е�1λָʾ�Ƿ���������Ϊ1������Ϊ0������lengthλ����ӽ��
	 */
	public String integerAddition (String operand1, String operand2, int length) {
		String output=adder(operand1, operand2, '0', length);
		return output;
	}
	
	/**
	 * �����������ɵ���{@link #adder(String, String, char, int) adder}����ʵ�֡�<br/>
	 * ����integerSubtraction("0100", "0011", 8)
	 * @param operand1 �����Ʋ����ʾ�ı�����
	 * @param operand2 �����Ʋ����ʾ�ļ���
	 * @param length ��Ų������ļĴ����ĳ��ȣ�Ϊ4�ı�����length��С�ڲ������ĳ��ȣ���ĳ���������ĳ���С��lengthʱ����Ҫ�ڸ�λ������λ
	 * @return ����Ϊlength+1���ַ�����ʾ�ļ����������е�1λָʾ�Ƿ���������Ϊ1������Ϊ0������lengthλ��������
	 */
	public String integerSubtraction (String operand1, String operand2, int length) {
		operand2=oneAdder(negation(operand2)).substring(1);
		return integerAddition(operand1, operand2, length);
		
	}
	
	/**
	 * �����˷���ʹ��Booth�㷨ʵ�֣��ɵ���{@link #adder(String, String, char, int) adder}�ȷ�����<br/>
	 * ����integerMultiplication("0100", "0011", 8)
	 * @param operand1 �����Ʋ����ʾ�ı�����
	 * @param operand2 �����Ʋ����ʾ�ĳ���
	 * @param length ��Ų������ļĴ����ĳ��ȣ�Ϊ4�ı�����length��С�ڲ������ĳ��ȣ���ĳ���������ĳ���С��lengthʱ����Ҫ�ڸ�λ������λ
	 * @return ����Ϊlength+1���ַ�����ʾ����˽�������е�1λָʾ�Ƿ���������Ϊ1������Ϊ0������lengthλ����˽��
	 */
	public String integerMultiplication (String operand1, String operand2, int length) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * �����Ĳ��ָ������������ɵ���{@link #adder(String, String, char, int) adder}�ȷ���ʵ�֡�<br/>
	 * ����integerDivision("0100", "0011", 8)
	 * @param operand1 �����Ʋ����ʾ�ı�����
	 * @param operand2 �����Ʋ����ʾ�ĳ���
	 * @param length ��Ų������ļĴ����ĳ��ȣ�Ϊ4�ı�����length��С�ڲ������ĳ��ȣ���ĳ���������ĳ���С��lengthʱ����Ҫ�ڸ�λ������λ
	 * @return ����Ϊ2*length+1���ַ�����ʾ�������������е�1λָʾ�Ƿ���������Ϊ1������Ϊ0�������lengthλΪ�̣����lengthλΪ����
	 */
	public String integerDivision (String operand1, String operand2, int length) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * �����������ӷ������Ե���{@link #adder(String, String, char, int) adder}�ȷ�����
	 * ������ֱ�ӽ�������ת��Ϊ�����ʹ��{@link #integerAddition(String, String, int) integerAddition}��
	 * {@link #integerSubtraction(String, String, int) integerSubtraction}��ʵ�֡�<br/>
	 * ����signedAddition("1100", "1011", 8)
	 * @param operand1 ������ԭ���ʾ�ı����������е�1λΪ����λ
	 * @param operand2 ������ԭ���ʾ�ļ��������е�1λΪ����λ
	 * @param length ��Ų������ļĴ����ĳ��ȣ�Ϊ4�ı�����length��С�ڲ������ĳ��ȣ����������ţ�����ĳ���������ĳ���С��lengthʱ����Ҫ���䳤����չ��length
	 * @return ����Ϊlength+2���ַ�����ʾ�ļ����������е�1λָʾ�Ƿ���������Ϊ1������Ϊ0������2λΪ����λ����lengthλ����ӽ��
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
	 * �������ӷ����ɵ���{@link #signedAddition(String, String, int) signedAddition}�ȷ���ʵ�֡�<br/>
	 * ����floatAddition("00111111010100000", "00111111001000000", 8, 8, 8)
	 * @param operand1 �����Ʊ�ʾ�ı�����
	 * @param operand2 �����Ʊ�ʾ�ļ���
	 * @param eLength ָ���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @param sLength β���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @param gLength ����λ�ĳ���
	 * @return ����Ϊ2+eLength+sLength���ַ�����ʾ����ӽ�������е�1λָʾ�Ƿ�ָ�����磨���Ϊ1������Ϊ0��������λ����������Ϊ���š�ָ���������ʾ����β������λ���أ����������Ϊ��0����
	 */
	public String floatAddition (String operand1, String operand2, int eLength, int sLength, int gLength) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * �������������ɵ���{@link #floatAddition(String, String, int, int, int) floatAddition}����ʵ�֡�<br/>
	 * ����floatSubtraction("00111111010100000", "00111111001000000", 8, 8, 8)
	 * @param operand1 �����Ʊ�ʾ�ı�����
	 * @param operand2 �����Ʊ�ʾ�ļ���
	 * @param eLength ָ���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @param sLength β���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @param gLength ����λ�ĳ���
	 * @return ����Ϊ2+eLength+sLength���ַ�����ʾ�������������е�1λָʾ�Ƿ�ָ�����磨���Ϊ1������Ϊ0��������λ����������Ϊ���š�ָ���������ʾ����β������λ���أ����������Ϊ��0����
	 */
	public String floatSubtraction (String operand1, String operand2, int eLength, int sLength, int gLength) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * �������˷����ɵ���{@link #integerMultiplication(String, String, int) integerMultiplication}�ȷ���ʵ�֡�<br/>
	 * ����floatMultiplication("00111110111000000", "00111111000000000", 8, 8)
	 * @param operand1 �����Ʊ�ʾ�ı�����
	 * @param operand2 �����Ʊ�ʾ�ĳ���
	 * @param eLength ָ���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @param sLength β���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @return ����Ϊ2+eLength+sLength���ַ�����ʾ����˽��,���е�1λָʾ�Ƿ�ָ�����磨���Ϊ1������Ϊ0��������λ����������Ϊ���š�ָ���������ʾ����β������λ���أ����������Ϊ��0����
	 */
	public String floatMultiplication (String operand1, String operand2, int eLength, int sLength) {
		// TODO YOUR CODE HERE.
		return null;
	}
	
	/**
	 * �������������ɵ���{@link #integerDivision(String, String, int) integerDivision}�ȷ���ʵ�֡�<br/>
	 * ����floatDivision("00111110111000000", "00111111000000000", 8, 8)
	 * @param operand1 �����Ʊ�ʾ�ı�����
	 * @param operand2 �����Ʊ�ʾ�ĳ���
	 * @param eLength ָ���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @param sLength β���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @return ����Ϊ2+eLength+sLength���ַ�����ʾ����˽��,���е�1λָʾ�Ƿ�ָ�����磨���Ϊ1������Ϊ0��������λ����������Ϊ���š�ָ���������ʾ����β������λ���أ����������Ϊ��0����
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
