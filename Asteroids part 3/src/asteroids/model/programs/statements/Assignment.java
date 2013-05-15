package asteroids.model.programs.statements;

import java.util.List;

import asteroids.model.programs.expressions.DoubleLiteral;
import asteroids.model.programs.expressions.Expression;

public class Assignment extends Statement {
	public Assignment(int line, int column, String variableName, Expression assignedE) {
		super(line, column);
		this.variableName = variableName;
		this.assignedE = assignedE;
	}
	
	private String variableName;
	
	private Expression assignedE;

	public String getVariableName() {
		return variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	public Expression getAssignedE() {
		return assignedE;
	}

	public void setAssignedE(Expression assignedE) {
		this.assignedE = assignedE;
	}
	
	@Override
	public void execute() {
		List<Statement> assignments = this.getShip().getProgram().getAssignments();
		for(Statement assign: assignments) {
			if(hasSameName(assign)&&!hasSameDouble(assign)) {
				((Assignment) assign).setAssignedE(this.getAssignedE());
			}
		}
	}
	
	private boolean hasSameDouble(Statement s) {
		return ((DoubleLiteral) ((Assignment) s).getAssignedE()).getDouble()==(((DoubleLiteral) this.getAssignedE()).getDouble());
	}
	
	private boolean hasSameName(Statement s) {
		return ((Assignment) s).getVariableName().equals(this.getVariableName());
	}
	
	@Override
	public String toString() {
		return assignedE.toString();
	}
}
