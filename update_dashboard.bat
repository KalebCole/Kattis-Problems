@echo off
echo ============================================
echo  Kattis Dashboard Generator
echo ============================================
echo.

python generate_dashboard.py

if %ERRORLEVEL% EQU 0 (
    echo.
    echo ============================================
    echo  Dashboard generated successfully!
    echo ============================================
    echo.
    echo Opening dashboard in browser...
    start kattis_dashboard.html
) else (
    echo.
    echo [ERROR] Dashboard generation failed.
    echo Please check if Python is installed and all files are present.
    pause
)
