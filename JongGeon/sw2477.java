import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Person{
	int r;
	int s;
	int time=0;
}
class Receipt{
	int size = 0;
	int Limit;
	Receipt[] node;
	int time=0;
	boolean status = false;
	int pid=0;
	
	Receipt(){
		
	}
	
	Receipt(int size){
		this.size=size;
		this.node = new Receipt[size];
		for(int i=0; i<size; i++) {
			this.node[i]= new Receipt();
		}
	}

}
class Service{
	int size = 0;
	int Limit;
	Service[] node;
	int time =0;
	int pid=0;
	boolean status = false;
	
	Service(){
		
	}
	Service(int size){
		this.size=size;
		this.node = new Service[size];
		for(int i=0; i<size; i++) {
			this.node[i]= new Service();
		}
	}
}

public class sw2477 {
	static int cnt=0;
	static int n,m,k,a,b;
	static List<Integer> list;
	static Person p[];
	static Receipt r;
	static Service s;
	static Queue<Integer> q1;
	static Queue<Integer> q2;
	static void doService() {
		for(int i=1; i<=m; i++) {
			if(!s.node[i].status) continue;
			if(++s.node[i].time == s.node[i].Limit) {
				cnt++;
				s.node[i].time=0;
				s.node[i].status=false;
				
				int pid = s.node[i].pid;
				
				if(p[pid].r == a && p[pid].s == b) {
					list.add(pid);
				}
				pid = 0;
			}
		}
	}
	
	static void enterService() {
		
		while(!q2.isEmpty()) {
			boolean find = false;
			for(int i=1; i<=m; i++) {
				if(!s.node[i].status) {
					int pid = q2.poll();
					p[pid].s=i;
					s.node[i].status=true;
					s.node[i].pid=pid;
					find = true;
					break;
				}
			}
			if(!find)
				return;
		}
	}
	
	static void doReceipt() {
		for(int i=1; i<=n; i++) {
			if(!r.node[i].status) continue;
			if(++r.node[i].time == r.node[i].Limit) {
				r.node[i].time =0;
				r.node[i].status=false;
				
				int pid = r.node[i].pid;
				q2.add(pid);
				r.node[i].pid = 0;
			}
		}
	}
	
	static void enterReceipt() {
		while(!q1.isEmpty()) {
			boolean find = false;
			for(int i=1; i<=n; i++) {
				if(!r.node[i].status) {
					int pid = q1.poll();
					p[pid].r=i;
					r.node[i].status = true;
					r.node[i].pid = pid;
					find = true;
					break;
				}
			}
			if(!find)
				return;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for(int t=1; t<=test; t++) {
			n=sc.nextInt();
			m=sc.nextInt();
			k=sc.nextInt();
			a=sc.nextInt();
			b=sc.nextInt();
			
			list = new ArrayList<Integer>();
			p = new Person[k+1];
			for(int i=0; i<=k; i++) {
				p[i] = new Person();
			}
			r = new Receipt(n+1);
			s = new Service(m+1);
			q1=new LinkedList<Integer>();
			q2= new LinkedList<Integer>();
			for(int i=1; i<=n; i++) {
				r.node[i].Limit = sc.nextInt();
			}
			for(int i=1; i<=m; i++) {
				s.node[i].Limit = sc.nextInt();
			}
			
			for(int i=1; i<=k; i++) {
				p[i].time = sc.nextInt();
			}
			
			sol(r,s,p);
			
			if(list.isEmpty())
				System.out.println("#" + t + " " + -1);
			else {
				int sum=0;
				for(int i=0; i<list.size(); i++) {
					sum+=list.get(i);
				}
				System.out.println("#" + t + " " + sum);
			}
		}
	}
	
	static void sol(Receipt r, Service s, Person[] p) {
		
		cnt =0;
		int idx = 1;
		int t=0;
		while(cnt!=k) {
			
			while(true) {
				if(idx>k) {
					break;
				}
				if(p[idx].time <= t) {
					q1.add(idx++);
					continue;
				}
				break;
			}
			doService();
			enterService();
			doReceipt();
			enterReceipt();
			t++;
		}
		
	}
}
