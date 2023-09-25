package com.github.kmax.undoelementmovedorrenamednotcalledonundofilemove

import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.refactoring.listeners.RefactoringElementAdapter
import com.intellij.refactoring.listeners.RefactoringElementListener
import com.intellij.refactoring.listeners.RefactoringElementListenerProvider

class TestRefactoringElementListenerProvider : RefactoringElementListenerProvider {

    override fun getListener(element: PsiElement?): RefactoringElementListener? =
        if (element is PsiFile || element is PsiDirectory) {
            object : RefactoringElementAdapter() {
                override fun undoElementMovedOrRenamed(newElement: PsiElement, oldQualifiedName: String) {
                    println("undoElementMovedOrRenamed: $newElement, $oldQualifiedName")
                }

                override fun elementRenamedOrMoved(newElement: PsiElement) {
                    println("elementRenamedOrMoved: $newElement")
                }
            }
        } else null

}