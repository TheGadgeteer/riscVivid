/*******************************************************************************
 * riscVivid - A RISC-V processor simulator.
 * Copyright (C) 2013-2016 The riscVivid project, University of Augsburg, Germany
 * <https://github.com/unia-sik/riscVivid>
 *
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program, see <LICENSE>. If not, see
 * <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package riscVivid.datatypes;

public enum ALUFunction
{
	ADD,
	ADDU,
	AND,
	BR, // branch relative
	BA, // branch absolute
	DIV,
	DIVU,
	REM,	// RISCV
	REMU,	// RISCV
	LUI,
	MULT,
	MULTU,
	MULH,	// RISCV
	MULHU,	// RISCV
	MULHSU,	// RISCV
	NOP,
	NOR,
	OR,
	SLL,
	SLLV,
	SEQ, // for DLX ISA only
	SEQU, // for DLX ISA only
	SNE, // for DLX ISA only
	SNEU, // for DLX ISA only
	SLE, // for DLX ISA only
	SLEU, // for DLX ISA only
	SGE, // for DLX ISA only
	SGEU, // for DLX ISA only
	SGT, // for DLX ISA only
	SGTU, // for DLX ISA only
	TRAP, // for DLX ISA only
	SLT,
	SLTU,
	SRL,
	SRLV,
	SRA,
	SRAV,
	SUB,
	SUBU,
	SYSCALL,
	TEQ,
	TGE,
	TGEU,
	TLT,
	TLTU,
	TNE,
	XOR
}
